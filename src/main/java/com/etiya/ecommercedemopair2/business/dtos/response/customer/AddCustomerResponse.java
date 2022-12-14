package com.etiya.ecommercedemopair2.business.dtos.response.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddCustomerResponse{
    private int id;
    private int paymentId;
    private int roleId;
    private int userId;

}
