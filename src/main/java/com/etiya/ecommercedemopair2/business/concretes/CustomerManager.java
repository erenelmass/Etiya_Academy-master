package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair2.business.abstracts.RoleService;
import com.etiya.ecommercedemopair2.business.abstracts.UserService;
import com.etiya.ecommercedemopair2.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.customer.AddCustomerResponse;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Customer;
import com.etiya.ecommercedemopair2.entities.concretes.Role;
import com.etiya.ecommercedemopair2.entities.concretes.User;
import com.etiya.ecommercedemopair2.repository.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;

    private RoleService roleService;
    private UserService userService;
    private ModelMapperService modelMapperService;
    @Override
    public DataResult<AddCustomerResponse> addCustomer(AddCustomerRequest addCustomerRequest) {
        Customer customer=modelMapperService.forRequest().map(addCustomerRequest,Customer.class);

        Customer savedCustomer=customerRepository.save(customer);

        AddCustomerResponse response=
                modelMapperService.forResponse().map(savedCustomer,AddCustomerResponse.class);
        return new SuccessDataResult<AddCustomerResponse>(response,"Müşteri eklendi.");
    }

    @Override
    public DataResult<Customer> getById(int customerId) {
        return new SuccessDataResult<Customer>
                (customerRepository.findById(customerId).orElseThrow(),"Id'ye göre listelendi.");

    }

    @Override
    public Page<Customer> findAllWithPagination(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }
}
