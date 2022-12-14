package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.OrderService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.order.AddOrderResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.order.AddOrderWithCustomerNameResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Order;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import com.etiya.ecommercedemopair2.business.abstracts.OrderService;
import com.etiya.ecommercedemopair2.entities.concretes.Order;
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
@RequestMapping(Paths.apiPrefix+"orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Order>> getAll(@RequestParam("id") int id ){
        return orderService.findAllOrdersOrderByOrder_date(id);
    }

    @GetMapping("/getById")
    public DataResult<Order> getByIdPath(@RequestParam("id") int id){
        return orderService.getById(id);
    }


   @PostMapping("/add")
    public DataResult<AddOrderResponse> addOrder(@RequestBody @Valid AddOrderRequest addOrderRequest){
       return new DataResult<>(orderService.addOrder(addOrderRequest).getData(),true,"Başarılı");
    }

    @GetMapping("/getorderWithCustomerName")
    public DataResult<List<AddOrderWithCustomerNameResponse>> orderWithCustomerName(){
        return new SuccessDataResult<List<AddOrderWithCustomerNameResponse>>(orderService.orderWithCustomerName().getData());

    }
    @GetMapping("/getWithPagination")
    //RequestParam: page.pageSize
    public Page<Order> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return orderService.findAllWithPagination(pageable);

    }
}
