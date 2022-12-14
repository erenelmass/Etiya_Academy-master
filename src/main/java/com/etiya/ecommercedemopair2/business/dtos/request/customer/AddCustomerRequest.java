package com.etiya.ecommercedemopair2.business.dtos.request.customer;

import com.etiya.ecommercedemopair2.business.constants.Messages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddCustomerRequest {
    @Min(value=1,message = "payment_id "+ Messages.Common.IdFieldNeedsToBeMinOne)
    private int paymentId;
    @Min(value=1,message = "role_id "+Messages.Common.IdFieldNeedsToBeMinOne)
    private int roleId;
    @Min(value=1,message = "user_id "+Messages.Common.IdFieldNeedsToBeMinOne)
    private int userId;
}
