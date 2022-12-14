package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair2.business.abstracts.OrderService;
import com.etiya.ecommercedemopair2.business.abstracts.PaymentMethodService;
import com.etiya.ecommercedemopair2.business.abstracts.ShipperService;
import com.etiya.ecommercedemopair2.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.order.AddOrderResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.order.AddOrderWithCustomerNameResponse;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair2.entities.concretes.*;
import com.etiya.ecommercedemopair2.repository.abstracts.OrderRepositoy;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private OrderRepositoy orderRepositoy;
    private ShipperService shipperService;
    private PaymentMethodService paymentMethodService;
    private CustomerService customerService;
    private ModelMapperService modelMapperService;
    @Override
    public DataResult<List<Order>> findAllOrdersOrderByOrder_date(int id) {
        return new SuccessDataResult<List<Order>>(orderRepositoy.getAllOrdersOrderById(id));

        //return null;
    }

    @Override
    public DataResult<Order> getById(int order_id) {

        return new SuccessDataResult<Order>(this.orderRepositoy.findById(order_id).orElseThrow(),"Id'ye göre listelendi.");
    }



    @Override
    public DataResult<AddOrderResponse> addOrder(AddOrderRequest addOrderRequest) {
        Order order=modelMapperService.forRequest().map(addOrderRequest,Order.class);

        Order savedOrder = orderRepositoy.save(order);

        AddOrderResponse response =
                modelMapperService.forResponse().map(savedOrder,AddOrderResponse.class);
        return new SuccessDataResult<AddOrderResponse>(response,"Sipariş Eklendi");
    }

    @Override
    public DataResult<List<AddOrderWithCustomerNameResponse>> orderWithCustomerName() {
        return new SuccessDataResult<List<AddOrderWithCustomerNameResponse>>(this.orderRepositoy.orderWithCustomerName());
    }

    @Override
    public Page<Order> findAllWithPagination(Pageable pageable) {
        return orderRepositoy.findAll(pageable);
    }
//    public List<Order> findAllProductsUnitPriceBetween(int id){
//        return orderRepositoy.findAllProductsUnitPriceBetween(id);
//    }
}
