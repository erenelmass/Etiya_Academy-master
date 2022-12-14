package com.etiya.ecommercedemopair2.business.dtos.response.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddOrderResponse {
    private int id;
    private Date orderDate;
    private Date shipDate;
    private int shipperId;
    private int paymentId;
    private int customerId;
}
