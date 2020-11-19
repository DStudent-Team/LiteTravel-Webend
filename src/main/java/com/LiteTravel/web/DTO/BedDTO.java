package com.LiteTravel.web.DTO;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class BedDTO {
    private Integer bedId;
    private String bedName;
    private BigDecimal bedSize;
    private Integer bedCount;

    public void setBedCount(Integer integer) {
    }
}
