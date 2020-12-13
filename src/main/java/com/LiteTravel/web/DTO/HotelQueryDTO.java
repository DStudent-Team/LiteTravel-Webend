package com.LiteTravel.web.DTO;

import lombok.Data;

@Data
public class HotelQueryDTO {

    String keyword;
    Integer minPrice;
    Integer maxPrice;
}
