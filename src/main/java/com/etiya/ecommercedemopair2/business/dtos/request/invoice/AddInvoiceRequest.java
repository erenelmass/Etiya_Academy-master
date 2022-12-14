package com.etiya.ecommercedemopair2.business.dtos.request.invoice;

import com.etiya.ecommercedemopair2.business.constants.Messages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddInvoiceRequest {
    @NotNull(message = "invoice_id "+ Messages.Common.IdFieldNeedsToBeMinOne)
    private String invoiceId;
    @Min(value=1,message = "order_detail_id "+Messages.Common.IdFieldNeedsToBeMinOne)
    private int orderDetailsId;
}
