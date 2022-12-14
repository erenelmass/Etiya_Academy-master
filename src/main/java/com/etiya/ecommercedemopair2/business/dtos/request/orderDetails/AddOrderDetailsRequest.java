package com.etiya.ecommercedemopair2.business.dtos.request.orderDetails;

import com.etiya.ecommercedemopair2.business.constants.Messages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderDetailsRequest {
    @Min(value=1,message = "orderId "+ Messages.Common.IdFieldNeedsToBeMinOne)
    private int orderId;
    @Min(value=1,message = "productId "+Messages.Common.IdFieldNeedsToBeMinOne)
    private int productId;
    private double total;
    private String coupon;
}
