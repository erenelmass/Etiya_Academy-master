package com.etiya.ecommercedemopair2.repository.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.response.product.ListProductResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.salesman.ListSalesmanResponse;
import com.etiya.ecommercedemopair2.entities.concretes.Salesman;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SalesmanRepository extends JpaRepository<Salesman,Integer> {
    @Query("Select new com.etiya.ecommercedemopair2.business.dtos.response.salesman.ListSalesmanResponse(p.id,p.companyName) from Salesman as p")
    Page<ListSalesmanResponse> getAllListSalesman(Pageable pageable);
}
