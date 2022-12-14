package com.etiya.ecommercedemopair2.repository.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.response.address.ListAddressResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.product.ListProductResponse;
import com.etiya.ecommercedemopair2.entities.concretes.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query("Select new com.etiya.ecommercedemopair2.business.dtos.response.address.ListAddressResponse(p.id,p.title) from Address as p")
    Page<ListAddressResponse> getAllListAddress(Pageable pageable);



}
