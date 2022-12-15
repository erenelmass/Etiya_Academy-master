package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.invoice.AddInvoiceRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.invoice.AddInvoiceResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.invoice.GetInvoiceResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Invoice;

import java.util.List;

public interface InvoiceService {
    DataResult<List<GetInvoiceResponse>> getAll();

    DataResult<AddInvoiceResponse> addInvoice(AddInvoiceRequest addInvoiceRequest);
}
