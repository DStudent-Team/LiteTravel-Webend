package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.AuthorityDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.DTO.UserManageDTO;
import com.LiteTravel.web.Model.Company;
import com.LiteTravel.web.Model.HotelManager;
import com.LiteTravel.web.Model.UserAuthority;
import com.LiteTravel.web.Model.UserAuthorityExample;
import com.LiteTravel.web.mapper.CompanyMapper;
import com.LiteTravel.web.mapper.HotelManagerMapper;
import com.LiteTravel.web.mapper.UserAuthorityMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAuthorityService {

    @Resource
    UserAuthorityMapper authorityMapper;

    @Autowired
    HotelManagerMapper hotelManagerMapper;

    @Autowired
    CompanyMapper companyMapper;

    /**
     *
     * @param page
     * @param pageSize
     * @param model
     */
    public void setAuthorityPage(Integer page, Integer pageSize, ModelMap model){
        ResultVO result = selectByExample(page, pageSize, new UserAuthorityExample());
        model.addAttribute("authorities", result.data);
        model.addAttribute("pageInfo", result.info);
    }
    private ResultVO selectByExample(Integer page, Integer pageSize,
                                     UserAuthorityExample authorityExample){
        PageHelper.startPage(page, pageSize);
        List<UserAuthority> userAuthorityList = authorityMapper.selectByExample(authorityExample);
        PageInfo<UserAuthority> info = new PageInfo<>(userAuthorityList,5);
        List<AuthorityDTO> data = userAuthorityList.stream().map(userAuthority -> {
            AuthorityDTO authorityDTO = new AuthorityDTO();
            BeanUtils.copyProperties(userAuthority, authorityDTO);
            return authorityDTO;
        }).collect(Collectors.toList());
        return new ResultVO(data, info);
    }


    /**
     * 可以更新所有权限
     * @param authorityDTO authorityDTO
     * @return int
     */
    public int updateAuthority(AuthorityDTO authorityDTO){
        UserAuthority userAuthority = new UserAuthority();
        BeanUtils.copyProperties(authorityDTO,userAuthority);

        /*添加对应的公司*/
        UserManageDTO userManageDTO = new UserManageDTO();
        userManageDTO.setUserName(authorityDTO.getUserName());
        userManageDTO.setAuthorityLevel(authorityDTO.getAuthorityLevel());
        userManageDTO.setUserPhone(authorityDTO.getUserPhone());
        Company company = companyMapper.selectByPrimaryKey(authorityDTO.getUserId());
        if(company == null){
            addCompany(authorityDTO.getUserId(), userManageDTO);
        }
        return authorityMapper.updateByPrimaryKeySelective(userAuthority);
    }

    /**
     * 添加用户权限level
     * @param userId userId
     * @param authorityLevel level
     * @return int
     */
    public int insertAuthority(Integer userId, Integer authorityLevel){
        UserAuthority userAuthority = new UserAuthority();
        userAuthority.setUserId(userId);
        userAuthority.setAuthorityLevel(authorityLevel);
        return authorityMapper.insert(userAuthority);
    }

    /**
     * 通过用户id查找权限
     * @param userId userId
     * @return int
     */
    public int findAuthorityLevelByUserId(Integer userId){
        UserAuthority userAuthority = authorityMapper.selectByPrimaryKey(userId);
        if (userAuthority == null){
            return -1;
        }
        else{
            return userAuthority.getAuthorityLevel();
        }
    }
    /*添加服务商信息*/
    public void addCompany(Integer userId, UserManageDTO userManageDTO){
        Integer authorityLevel = userManageDTO.getAuthorityLevel();
        String userName = userManageDTO.getUserName();
        /*用户级别2：飞机服务商*/
        if (authorityLevel == 2 || authorityLevel ==4 ){
            Company company = new Company();
            company.setCompanyId(userId);
            company.setCompanyName(userName);
            companyMapper.insert(company);
        }
//        /*用户级别3：酒店服务商*/
//        else if (authorityLevel == 3) {
//            HotelManager hotelManager =new HotelManager();
//            hotelManager.setHotelManagerId(userId);
//            hotelManager.setHotelManagerName(userName);
//            hotelManager.setHotelManagerPhone(userManageDTO.getUserPhone());
//            hotelManagerMapper.insert(hotelManager);
//
//        }
        /*用户级别4：旅游集团(飞机加酒店)*/
//        else if (authorityLevel == 4) {
//            Company company = new Company();
//            company.setCompanyId(userId);
//            company.setCompanyName(userName);
//            companyMapper.insert(company);
//
//            HotelManager hotelManager =new HotelManager();
//            hotelManager.setHotelManagerId(userId);
//            hotelManager.setHotelManagerName(userName);
//            hotelManager.setHotelManagerPhone(userManageDTO.getUserPhone());
//            hotelManagerMapper.insert(hotelManager);
//        }
    }


}
