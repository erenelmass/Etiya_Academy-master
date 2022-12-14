package com.etiya.ecommercedemopair2.business.dtos.response.paymentmethod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddPaymentMethodResponse {
    private int id;
    private String name;
}
