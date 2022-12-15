package com.etiya.ecommercedemopair2.business.dtos.response.invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInvoiceResponse {
    private String invoiceId;
    private Date invoiceDate;
    private double total;
    private int orderDetailsId;
}
