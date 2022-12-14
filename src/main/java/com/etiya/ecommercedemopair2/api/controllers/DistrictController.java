package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.DistrictService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.district.AddDistrictRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.district.AddDistrictResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.district.ListDistrictResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.product.ListProductResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.District;
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
@RequestMapping(Paths.apiPrefix+"districts")
public class DistrictController {
    private DistrictService districtService;

    @Autowired
    DistrictController(DistrictService districtService){
        this.districtService=districtService;
    }

    @PostMapping("/add")
    public DataResult<AddDistrictResponse> addDistrict(@RequestBody @Valid AddDistrictRequest addDistrictRequest){
        return new DataResult<AddDistrictResponse>(districtService.addDistrict(addDistrictRequest).getData(),true,"Başarılı");
    }

    @GetMapping("/getById")
    public DataResult<District> getById(@RequestParam("id") int id){
        return districtService.getById(id);
    }
    @GetMapping("/getWithPagination")
    //RequestParam: page.pageSize
    public Page<District> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return districtService.findAllWithPagination(pageable);

    }


    @GetMapping("/getWithPaginationDto")
    // RequestParam => page,pageSize
    public Page<ListDistrictResponse>
    getWithPaginationDto(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return districtService.findAllWithPaginationDto(pageable);
    }
}
