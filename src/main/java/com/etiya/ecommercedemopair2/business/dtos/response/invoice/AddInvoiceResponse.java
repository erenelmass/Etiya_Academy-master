package com.etiya.ecommercedemopair2.business.dtos.response.invoice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddInvoiceResponse {
    private int id;
    private String invoiceId;
    private Date invoiceDate;
    private double total;
    private int orderDetailsId;
}
