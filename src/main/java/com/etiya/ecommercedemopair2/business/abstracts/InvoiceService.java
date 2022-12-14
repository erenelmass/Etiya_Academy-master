package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.response.invoice.GetInvoiceResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;

public interface InvoiceService {
    DataResult<GetInvoiceResponse> getAll();
}
