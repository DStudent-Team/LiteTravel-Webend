package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.Guide.GuideDTO;
import com.LiteTravel.web.DTO.Guide.GuideSearchDTO;
import com.LiteTravel.web.DTO.ResponseDTO;
import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.DTO.UserDTO;
import com.LiteTravel.web.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class GuideController {
    /*
    * 导航控制器
    * 基本只是用来保存基本的数据内容, 并不会大量产生复杂数据
    * */
    @Autowired
    GuideService guideService;

    @GetMapping("/guide")
    public String getGuidesByUserId(ModelMap model, HttpSession session){
        GuideSearchDTO guideSearchDTO = new GuideSearchDTO();
        guideSearchDTO.setUserId(((UserDTO) session.getAttribute("user")).getUserId());
        ResultVO result = guideService.getGuides(guideSearchDTO);
        model.addAttribute("guides", result.data);
        return "guide";
    }
    @PostMapping("/guide")
    public String getGuides(GuideSearchDTO guideSearchDTO, ModelMap model){
        ResultVO result = guideService.getGuides(guideSearchDTO);
        model.addAttribute("guides", result.data);
        return "guide";
    }

    @PostMapping("/guide/search")
    @ResponseBody
    public ResponseDTO saveSearchInfo(@RequestBody GuideDTO guideDTO){
        guideService.insertGuide(guideDTO);
        return ResponseDTO.successOf();
    }

}
