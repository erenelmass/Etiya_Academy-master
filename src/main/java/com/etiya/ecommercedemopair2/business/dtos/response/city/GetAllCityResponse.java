package com.etiya.ecommercedemopair2.business.dtos.response.city;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class GetAllCityResponse {
    private int id;
    private String cityName;
    private int countryId;
}
