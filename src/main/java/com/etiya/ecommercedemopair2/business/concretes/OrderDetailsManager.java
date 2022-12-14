package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.OrderDetailsService;
import com.etiya.ecommercedemopair2.business.abstracts.OrderService;
import com.etiya.ecommercedemopair2.business.abstracts.ProductService;
import com.etiya.ecommercedemopair2.business.dtos.request.orderDetails.AddOrderDetailsRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.orderDetails.AddOrderDetailsResponse;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Order;
import com.etiya.ecommercedemopair2.entities.concretes.OrderDetail;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import com.etiya.ecommercedemopair2.repository.abstracts.OrderDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderDetailsManager implements OrderDetailsService {
    private OrderDetailsRepository orderDetailsRepository;
    private OrderService orderService;
    private ProductService productService;
    private ModelMapperService modelMapperService;
    @Override
    public DataResult<AddOrderDetailsResponse> addOrderDetails(AddOrderDetailsRequest addOrderDetailsRequest) {
       OrderDetail orderDetail=modelMapperService.forRequest().map(addOrderDetailsRequest,OrderDetail.class);

        OrderDetail savedOrderDetail = orderDetailsRepository.save(orderDetail);

        AddOrderDetailsResponse response=
                modelMapperService.forResponse().map(savedOrderDetail,AddOrderDetailsResponse.class);
        return new SuccessDataResult<AddOrderDetailsResponse>(response,"Sipariş Detayı Eklendi.");
    }

    @Override
    public Page<OrderDetail> findAllWithPagination(Pageable pageable) {
        return orderDetailsRepository.findAll(pageable);
    }
}
