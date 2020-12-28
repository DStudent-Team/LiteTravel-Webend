package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.DTO.UserManageDTO;
import com.LiteTravel.web.Model.User;
import com.LiteTravel.web.service.UserAuthorityService;
import com.LiteTravel.web.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Controller
public class AdminUserController {
    @Resource
    UserService userService;

    @Resource
    private UserAuthorityService userAuthorityService;

    @GetMapping("/manage/users")
    public String userList(@RequestParam(value = "page", defaultValue = "1")Integer page, ModelMap model){
        ResultVO resultVO = userService.getUsers(page, 7);
        model.addAttribute("users", resultVO.data);
        model.addAttribute("pageInfo", resultVO.info);
        return "user/list";
    }


    /*后台添加用户信息*/
    @PostMapping("/manage/user")
    public String insertUser(UserManageDTO userManageDTO,
                             Map<String, Object> map){
        String userCode = userManageDTO.getUserCode();
        List<User> userList = userService.selectByCode(userCode);
        if(userList.size() > 0){
            map.put("msg","账号已存在！");
            System.out.println("账号已存在！");
            return "redirect:/manage/users";
        }else{
            userService.addUserByManager(userManageDTO,"insert");
        }
        return "redirect:/manage/users";
    }


    /*删除用户信息*/
    @PostMapping("manage/deleteUser")
    public String deleteUser(User user, Map<String, Object> map){
        int id = userService.deleteUser(user.getUserId());
        if(id == 1){
            return "redirect:/manage/users";
        }else{
            map.put("msg","删除失败！");
            return "redirect:/manage/users";
        }
    }

    /*更新用户信息*/
    @PutMapping("manage/user")
    public String updateUser(UserManageDTO userManageDTO,
                             Map<String, Object> map){
        String userCode = userManageDTO.getUserCode();
        String userPassword = userManageDTO.getUserPassword();
        String userName = userManageDTO.getUserName();
        if(StringUtils.isAllBlank(userCode) || StringUtils.isAllBlank(userPassword) || StringUtils.isAllBlank(userName)){
            map.put("msg","账号、密码、昵称不能为空！");
            System.out.println("账号、密码、昵称不能为空！");
            return "redirect:/manage/users";
        }else {
            userService.addUserByManager(userManageDTO, "update");
        }
        return "redirect:/manage/users";
    }

}
