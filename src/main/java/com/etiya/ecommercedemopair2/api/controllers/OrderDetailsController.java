package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.OrderDetailsService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.orderDetails.AddOrderDetailsRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.orderDetails.AddOrderDetailsResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.OrderDetail;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(Paths.apiPrefix+"orderDetails")
@AllArgsConstructor
public class OrderDetailsController {
    private OrderDetailsService orderDetailsService;

    @PostMapping("/add")
    public DataResult<AddOrderDetailsResponse> addOrderDetail(@RequestBody @Valid AddOrderDetailsRequest addOrderDetailsRequest){
        return new DataResult<AddOrderDetailsResponse>(orderDetailsService.addOrderDetails(addOrderDetailsRequest).getData(),true,"Başarılı");
    }
    @GetMapping("/getWithPagination")
    //RequestParam: page.pageSize
    public Page<OrderDetail> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return orderDetailsService.findAllWithPagination(pageable);

    }
}
