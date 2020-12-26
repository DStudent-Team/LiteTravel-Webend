package com.LiteTravel.web.DTO.Flight;

import lombok.Data;

/**
 * @Author xiaobai
 * @Date 2020/12/26 22:51
 * @Version 1.0
 */
@Data
public class TransactionDTO {
    private Integer userId;
    private Integer adminId;
    private Float money;
}
