package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.PaymentMethodService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.paymentmethod.AddPaymentMethodRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.paymentmethod.AddPaymentMethodResponse;


import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.PaymenMethod;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"PaymentMethods")
public class PaymentMethodsController {

    private PaymentMethodService paymentMethodService;

    @GetMapping("")
    public DataResult<List<PaymenMethod>> getAll(){
        return paymentMethodService.getAll();
    }

   @Autowired
   PaymentMethodsController(PaymentMethodService paymentMethodService){
       this.paymentMethodService=paymentMethodService;
   }

    @PostMapping("/add")
    public DataResult<AddPaymentMethodResponse> addPaymentMethod(@RequestBody @Valid AddPaymentMethodRequest addPaymentMethodRequest){
        return new DataResult<AddPaymentMethodResponse>(paymentMethodService.addPaymentMethod(addPaymentMethodRequest).getData(),true,"Başarılı");
    }

    @GetMapping("/getById")
    public DataResult<PaymenMethod> getByIdPath(@RequestParam("id") int id){
        return paymentMethodService.getById(id);
    }
    @GetMapping("/getWithPagination")
    //RequestParam: page.pageSize
    public Page<PaymenMethod> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return paymentMethodService.findAllWithPagination(pageable);

    }
}
