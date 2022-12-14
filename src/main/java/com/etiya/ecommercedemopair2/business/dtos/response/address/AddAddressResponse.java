package com.etiya.ecommercedemopair2.business.dtos.response.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddAddressResponse {
    private int id;
    private String title;
    private int districtId;
    private int userId;

}
