package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.*;
import com.LiteTravel.web.Model.*;
import com.LiteTravel.web.mapper.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserAuthorityMapper userAuthorityMapper;

    @Autowired
    UserAuthorityService userAuthorityService;




    public List<User> checkUserValid(String userCode, String userPassword){
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUserCodeEqualTo(userCode)
                .andUserPasswordEqualTo(userPassword)
                .andUserStateEqualTo(1);
        return userMapper.selectByExample(userExample);
    }
    public List<User> checkPasswordValid(Integer userId, String userPassword){
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andUserPasswordEqualTo(userPassword)
                .andUserStateEqualTo(1);
        return userMapper.selectByExample(userExample);
    }

    public UserInfo selectInfoByUserId(Integer userId){
        return userInfoMapper.selectByPrimaryKey(userId);
    }

    public void insert(User user) {
        userMapper.insert(user);
    }
    public void insert(UserInfo info) {
        userInfoMapper.insert(info);
    }
    @Cacheable("users")
    public List<User> selectByCode(String userCode) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUserCodeEqualTo(userCode);
        return userMapper.selectByExample(userExample);
    }

    public void updateInfo(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }

//    修改用户信息
    public int modifyInfo(UserInfoDTO userInfoDTO) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoDTO, userInfo);
        System.out.println(userInfoDTO);
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

//    获取用户分页信息数据
    public ResultVO getUsers(Integer page, Integer pageSize){
        return selectByExample(page, pageSize, new UserInfoExample());
    }

    private ResultVO selectByExample(Integer page, Integer pageSize, UserInfoExample userInfoExample) {
        /* 分页：
         * 参数1: 第几页
         * 参数2: 每页展示几个数据 */
        PageHelper.startPage(page, pageSize);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
        PageInfo<UserInfo> info = new PageInfo<>(userInfos, 5);
        List<Integer> userIds = userInfos.stream().map(UserInfo::getUserId).distinct().collect(Collectors.toList());
        Map<Integer, String> userCodeMap;
        Map<Integer, String> userPasswordMap;
        Map<Integer, Integer> userStateMap;
        Map<Integer, Integer> authorityLevelMap;
        if(userIds.size() > 0){
            /*查询账号表*/
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andUserIdIn(userIds);
            List<User> users = userMapper.selectByExample(userExample);
            userCodeMap = users.stream().collect(Collectors.toMap(User::getUserId, User::getUserCode));
            userPasswordMap = users.stream().collect(Collectors.toMap(User::getUserId, User::getUserPassword));
            userStateMap = users.stream().collect(Collectors.toMap(User::getUserId, User::getUserState));

            /*查询权限表*/
            UserAuthorityExample userAuthorityExample = new UserAuthorityExample();
            userAuthorityExample.createCriteria()
                    .andUserIdIn(userIds);
            List<UserAuthority> userAuthorities = userAuthorityMapper.selectByExample(userAuthorityExample);
            authorityLevelMap = userAuthorities.stream().collect(Collectors.toMap(UserAuthority::getUserId,UserAuthority::getAuthorityLevel));

        }else {
            userCodeMap = new HashMap<>();
            userPasswordMap = new HashMap<>();
            userStateMap = new HashMap<>();
            authorityLevelMap = new HashMap<>();
        }
        List<UserManageDTO> data = userInfos.stream().map(userInfo -> {
            UserManageDTO userManageDTO = new UserManageDTO();
            BeanUtils.copyProperties(userInfo, userManageDTO);
            String userCode = userCodeMap.get(userInfo.getUserId());
            String userPassword = userPasswordMap.get(userInfo.getUserId());
            Integer userState = userStateMap.get(userInfo.getUserId());
            Integer authorityLevel = authorityLevelMap.get(userInfo.getUserId());
            userManageDTO.setUserCode(userCode);
            userManageDTO.setUserPassword(userPassword);
            userManageDTO.setUserState(userState);
            userManageDTO.setAuthorityLevel(authorityLevel);
            return userManageDTO;
        }).collect(Collectors.toList());
        return new ResultVO(data, info);
    }

    /*后台添加用户信息(tag=insert)和更新用户信息(tag=update) 添加两个表  */
    public void addUserByManager(UserManageDTO userManageDTO, String tag){
        /*user_account*/
        User user = new User();
        user.setUserCode(userManageDTO.getUserCode());
        user.setUserPassword(userManageDTO.getUserPassword());
        user.setUserState(1);

        /*userAuthority*/
        UserAuthority userAuthority = new UserAuthority();
        userAuthority.setAuthorityLevel(userManageDTO.getAuthorityLevel());


        /*user_info*/
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userManageDTO.getUserName());
        userInfo.setUserGender(0);
        userInfo.setUserBirth(userManageDTO.getUserBirth());
        userInfo.setUserEmail(userManageDTO.getUserEmail());
        userInfo.setUserPhone(userManageDTO.getUserPhone());
        userInfo.setUserAddressSpecific(userManageDTO.getUserAddressSpecific());
        userInfo.setUserAvatarUri("avatar.jpg");

        if(tag.equals("insert")){
            insert(user);
            userInfo.setUserId(user.getUserId());
            insert(userInfo);
            userAuthorityService.insertAuthority(user.getUserId(), userManageDTO.getAuthorityLevel());
            /*根据权限等级设置相应的服务商*/
            userAuthorityService.addCompany(user.getUserId(),userManageDTO);
            System.out.println("保存成功！"+user);
        }
        else if(tag.equals("update")){
            user.setUserId(userManageDTO.getUserId());
            userInfo.setUserId(userManageDTO.getUserId());
            userAuthority.setUserId(userManageDTO.getUserId());
            userMapper.updateByPrimaryKeySelective(user);
            userInfoMapper.updateByPrimaryKeySelective(userInfo);
            userAuthorityMapper.updateByPrimaryKeySelective(userAuthority);
            /*根据权限等级设置相应的服务商*/
            userAuthorityService.addCompany(user.getUserId(),userManageDTO);
            System.out.println("修改成功！"+user);
        }
    }


    /*删除用户信息 包括账号信息和具体信息*/
    public int deleteUser(Integer userId){
        int id = userMapper.deleteByPrimaryKey(userId);
        int infoId = userInfoMapper.deleteByPrimaryKey(userId);
        if(id == 1 && infoId == 1){
            return 1;
        }else{
            return 0;
        }
    }




}
