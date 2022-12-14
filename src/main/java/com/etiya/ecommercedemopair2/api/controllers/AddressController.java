package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.AddressService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.address.ListAddressResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.product.ListProductResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Address;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(Paths.apiPrefix+"address")
public class AddressController {
    private AddressService addressService;

    @Autowired
    AddressController(AddressService addressService){
        this.addressService=addressService;
    }

    @PostMapping("/add")
    public DataResult<AddAddressResponse> addAddress (@RequestBody @Valid AddAddressRequest addAddressRequest){
        return new DataResult<AddAddressResponse>(addressService.addAddress(addAddressRequest).getData(), true,"Başarılı");
    }

    @GetMapping("/getWithPagination")
    //RequestParam: page.pageSize
    public Page<Address> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return addressService.findAllWithPagination(pageable);

    }


    @GetMapping("/getWithPaginationDto")
    // RequestParam => page,pageSize
    public Page<ListAddressResponse>
    getWithPaginationDto(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return addressService.findAllWithPaginationDto(pageable);
    }
}
