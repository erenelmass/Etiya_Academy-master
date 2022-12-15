package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.InvoiceService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.invoice.AddInvoiceRequest;
import com.etiya.ecommercedemopair2.business.dtos.request.orderDetails.AddOrderDetailsRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.invoice.AddInvoiceResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.invoice.GetInvoiceResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.orderDetails.AddOrderDetailsResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(name = Paths.apiPrefix+"invoices")
public class InvoiceController {
    private InvoiceService invoiceService;

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<GetInvoiceResponse>>> getAllInvoices(){
        return new ResponseEntity<DataResult<List<GetInvoiceResponse>>>(invoiceService.getAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/add")
    public DataResult<AddInvoiceResponse> addInvoice(@RequestBody @Valid AddInvoiceRequest addInvoiceRequest){
        return new DataResult<AddInvoiceResponse>(invoiceService.addInvoice(addInvoiceRequest).getData(),true,"Başarılı");
    }
}
