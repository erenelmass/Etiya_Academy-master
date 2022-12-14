package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.PaymentMethodService;
import com.etiya.ecommercedemopair2.business.dtos.request.paymentmethod.AddPaymentMethodRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.paymentmethod.AddPaymentMethodResponse;

import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair2.entities.concretes.PaymenMethod;
import com.etiya.ecommercedemopair2.repository.abstracts.PaymentMethodRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentMethodManager implements PaymentMethodService{

    private PaymentMethodRepository paymentMethodRepository;
    private ModelMapperService modelMapperService;

    public DataResult<List<PaymenMethod>> getAll(){
        return new SuccessDataResult<List<PaymenMethod>>(paymentMethodRepository.findAll(),"Data Listelendi.");

    }

    @Override
    public DataResult<PaymenMethod> getById(int id) {
        return new SuccessDataResult<PaymenMethod>(paymentMethodRepository.findById(id).orElseThrow(),"Id'ye göre listelendi.");

    }

    @Override
    public DataResult<AddPaymentMethodResponse> addPaymentMethod(AddPaymentMethodRequest addPaymentMethodRequest) {
        PaymenMethod paymentMethod=modelMapperService.forRequest().map(addPaymentMethodRequest,PaymenMethod.class);

        PaymenMethod savedPaymentMethod=paymentMethodRepository.save(paymentMethod);

        AddPaymentMethodResponse response =
                modelMapperService.forResponse().map(savedPaymentMethod,AddPaymentMethodResponse.class);

        return new SuccessDataResult<AddPaymentMethodResponse>(response,"Ödeme yöntemi eklendi.");
    }

    @Override
    public Page<PaymenMethod> findAllWithPagination(Pageable pageable) {
        return paymentMethodRepository.findAll(pageable);
    }

}
