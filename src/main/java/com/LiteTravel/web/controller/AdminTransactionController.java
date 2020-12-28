package com.LiteTravel.web.controller;

import com.LiteTravel.web.DTO.ResultVO;
import com.LiteTravel.web.service.Utils.MoneyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @Author xiaobai
 * @Date 2020/12/27 12:06
 * @Version 1.0
 */
@Controller
public class AdminTransactionController {

    @Resource
    private MoneyService moneyService;

    @GetMapping("/manage/transactions")
    public String listTransactions(@RequestParam(value = "page", defaultValue = "1") Integer pageNum, Model model){

        ResultVO resultVO = moneyService.listTransactions(pageNum,5);
        model.addAttribute("transactions", resultVO.data);
        model.addAttribute("pageInfo", resultVO.info);
        return "user/transaction";
    }
}
