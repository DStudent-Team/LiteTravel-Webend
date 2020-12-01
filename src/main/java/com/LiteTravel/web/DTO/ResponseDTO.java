package com.LiteTravel.web.DTO;

import com.LiteTravel.web.exception.CustomizeErrorCode;
import com.LiteTravel.web.exception.CustomizeException;

import java.io.Serializable;

public class ResponseDTO<T> implements Serializable {
    //请求代码
    public Integer code;
    //请求信息
    public String message;
    //传输的数据
    public T data;

    public static ResponseDTO errorOf(Integer code, String message){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(code);
        responseDTO.setMessage(message);
        return responseDTO;
    }
    public static ResponseDTO errorOf(CustomizeException customizeException){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(customizeException.getCode());
        responseDTO.setMessage(customizeException.getMessage());
        return responseDTO;
    }
    public static ResponseDTO errorOf(CustomizeErrorCode customizeErrorCode){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(customizeErrorCode.getCode());
        responseDTO.setMessage(customizeErrorCode.getMessage());
        return responseDTO;
    }
    public static ResponseDTO successOf(){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(200);
        responseDTO.setMessage("请求成功");
        return responseDTO;
    }
    public static ResponseDTO<Object> success(Object object){
        ResponseDTO<Object> responseDTO = new ResponseDTO<>();
        responseDTO.setCode(200);
        responseDTO.setMessage("请求成功");
        responseDTO.setData(object);
        return responseDTO;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data){
        this.data = data;
    }
}
