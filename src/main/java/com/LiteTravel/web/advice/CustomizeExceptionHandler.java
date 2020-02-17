// 统一控制错误显示页面
// 实际需要另外单独分开出来一个模块来管理所有的错误显示
package com.LiteTravel.web.advice;

import com.LiteTravel.web.DTO.ResponseDTO;
import com.LiteTravel.web.exception.CustomizeErrorCode;
import com.LiteTravel.web.exception.CustomizeException;
import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handler(Throwable e, Model model, HttpServletRequest request, HttpServletResponse response){
        String contentType = request.getContentType();
        if("application/json".equals(contentType)){
            ResponseDTO responseDTO;
            if(e instanceof CustomizeException){
                responseDTO = ResponseDTO.errorOf((CustomizeException) e);
            } else {
                responseDTO = ResponseDTO.errorOf(CustomizeErrorCode.DEFAULT_ERROR);
            }
            try {
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSONUtils.toJSONString(responseDTO));
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return null;
        }else {
            if(e instanceof CustomizeException){
                model.addAttribute("message", e.getMessage());
            } else {
                model.addAttribute("message", CustomizeErrorCode.DEFAULT_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }

   }
}
