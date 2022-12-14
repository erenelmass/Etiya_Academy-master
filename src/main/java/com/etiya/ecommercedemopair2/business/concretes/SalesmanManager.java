package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.RoleService;
import com.etiya.ecommercedemopair2.business.abstracts.SalesmanServise;
import com.etiya.ecommercedemopair2.business.abstracts.UserService;
import com.etiya.ecommercedemopair2.business.dtos.request.salesman.AddSalesmanRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.salesman.AddSalesmanResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.salesman.ListSalesmanResponse;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Role;
import com.etiya.ecommercedemopair2.entities.concretes.Salesman;
import com.etiya.ecommercedemopair2.entities.concretes.User;
import com.etiya.ecommercedemopair2.repository.abstracts.SalesmanRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SalesmanManager implements SalesmanServise {
    private SalesmanRepository salesmanRepository;
    private RoleService roleService;
    private UserService userService;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<AddSalesmanResponse> addSalesman(AddSalesmanRequest addSalesmanRequest) {
        Salesman salesman=modelMapperService.forRequest().map(addSalesmanRequest,Salesman.class);

        Salesman savedSalesman=salesmanRepository.save(salesman);

        AddSalesmanResponse response=
                modelMapperService.forResponse().map(savedSalesman,AddSalesmanResponse.class);

        return new SuccessDataResult<AddSalesmanResponse>(response,"Satıcı eklendi.");
    }

    @Override
    public Page<Salesman> findAllWithPagination(Pageable pageable) {
        return salesmanRepository.findAll(pageable);
    }

    @Override
    public Page<ListSalesmanResponse> findAllWithPaginationDto(Pageable pageable) {
        return salesmanRepository.getAllListSalesman(pageable);
    }
}
