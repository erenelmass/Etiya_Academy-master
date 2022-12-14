package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.SalesmanServise;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.salesman.AddSalesmanRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.product.ListProductResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.salesman.AddSalesmanResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.salesman.ListSalesmanResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import com.etiya.ecommercedemopair2.entities.concretes.Salesman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(Paths.apiPrefix+"salesmans")
public class SalesmanController {

    private SalesmanServise salesmanServise;

    @Autowired
    SalesmanController(SalesmanServise salesmanServise){
        this.salesmanServise=salesmanServise;
    }

    @PostMapping("/add")
    public DataResult<AddSalesmanResponse> addSalesman (@RequestBody @Valid AddSalesmanRequest addSalesmanRequest){
        return new DataResult<AddSalesmanResponse>(salesmanServise.addSalesman(addSalesmanRequest).getData(),true,"Başarılı");
    }

    @GetMapping("/getWithPagination")
    //RequestParam: page.pageSize
    public Page<Salesman> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return salesmanServise.findAllWithPagination(pageable);

    }


    @GetMapping("/getWithPaginationDto")
    // RequestParam => page,pageSize
    public Page<ListSalesmanResponse>
    getWithPaginationDto(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return salesmanServise.findAllWithPaginationDto(pageable);
    }
}
