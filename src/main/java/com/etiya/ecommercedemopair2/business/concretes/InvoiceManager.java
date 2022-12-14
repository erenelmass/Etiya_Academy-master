package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.InvoiceService;
import com.etiya.ecommercedemopair2.business.dtos.response.invoice.GetInvoiceResponse;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Invoice;
import com.etiya.ecommercedemopair2.repository.abstracts.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private InvoiceRepository invoiceRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<GetInvoiceResponse> getAll() {
        List<Invoice> invoices = invoiceRepository.findAll();
        List<GetInvoiceResponse> responses = invoices.stream().map(invoice -> modelMapperService.forResponse().map(invoice, GetInvoiceResponse.class)
        ).collect(Collectors.toList());
        return new SuccessDataResult<>(responses);
    }
}
