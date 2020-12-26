package com.LiteTravel.web.service;

import com.LiteTravel.web.DTO.AuthorityDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.Model.UserAuthority;
import com.LiteTravel.web.Model.UserAuthorityExample;
import com.LiteTravel.web.mapper.UserAuthorityMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAuthorityService {
    @Autowired
    UserAuthorityMapper authorityMapper;

    /*获取用户权限列表*/
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

//    public int updateAuthority(@PathParam("userId") Integer userId,
//                               @PathParam("authorityLevel") Integer blogTitle,
//                               @PathParam("hotelAuthority") Boolean blogContent,
//                               @PathParam("flightAuthority") Boolean blogTags){
//
//    }
}
