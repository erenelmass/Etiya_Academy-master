package com.etiya.ecommercedemopair2.business.dtos.response.district;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddDistrictResponse {
    private int id;
    private String districtName;
    private int cityId;
}
