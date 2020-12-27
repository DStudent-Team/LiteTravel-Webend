package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.AuthorityDTO;
import com.LiteTravel.web.service.UserAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author xiaobai
 */
@Controller
public class AdminAuthorityController {
    @Resource
    UserAuthorityService userAuthorityService;

    @GetMapping("manager/authority")
    public String getAuthorities(@RequestParam(value = "page",defaultValue = "1") Integer page, ModelMap model){
        userAuthorityService.setAuthorityPage(page,6, model);
        return "user/authority";
    }

    @PostMapping("manager/authority/update")
    public String updateAuthority(AuthorityDTO authorityDTO, Model model){
        int flag = userAuthorityService.updateAuthority(authorityDTO);
        if (flag == 1){
            model.addAttribute("message", "更新成功");
        }
        else{
            model.addAttribute("message", "更新失败");
        }
        return "user/authority";
    }

}
