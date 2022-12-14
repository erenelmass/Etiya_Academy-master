package com.etiya.ecommercedemopair2.business.dtos.response.shipper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddShipperResponse {
    private int id;
    private String companyName;
    private String phoneNumber;
    private int roleId;
}
