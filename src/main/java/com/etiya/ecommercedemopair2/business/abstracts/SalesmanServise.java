package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.salesman.AddSalesmanRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.product.ListProductResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.salesman.AddSalesmanResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.salesman.ListSalesmanResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import com.etiya.ecommercedemopair2.entities.concretes.Salesman;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SalesmanServise {
    DataResult<AddSalesmanResponse> addSalesman(AddSalesmanRequest addSalesmanRequest);
    Page<Salesman> findAllWithPagination(Pageable pageable);

    Page<ListSalesmanResponse> findAllWithPaginationDto(Pageable pageable);
}
