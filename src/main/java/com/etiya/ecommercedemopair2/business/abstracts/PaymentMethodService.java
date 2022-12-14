package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.paymentmethod.AddPaymentMethodRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.paymentmethod.AddPaymentMethodResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.PaymenMethod;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface PaymentMethodService {

    DataResult<List<PaymenMethod>> getAll();

    DataResult<PaymenMethod> getById(int id);

    DataResult<AddPaymentMethodResponse> addPaymentMethod(AddPaymentMethodRequest addPaymentMethodRequest);

    Page<PaymenMethod> findAllWithPagination(Pageable pageable);
}
