package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.CountryService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.country.AddCountryResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Country;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(Paths.apiPrefix+"countries")
public class CountryController {
    private CountryService countryService;

    @Autowired
    CountryController(CountryService countryService){
        this.countryService=countryService;
    }

    @PostMapping("/add")
    public DataResult<AddCountryResponse> addCountry(@RequestBody @Valid AddCountryRequest addCountryRequest){
        return new DataResult<AddCountryResponse>(countryService.addCountry(addCountryRequest).getData(),true,"Başarılı");
    }
    @GetMapping("/getById")
    public DataResult<Country> getById(@RequestParam("id") int id){
        return countryService.getById(id);
    }

    @GetMapping("/getWithPagination")
    //RequestParam: page.pageSize
    public Page<Country> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return countryService.findAllWithPagination(pageable);

    }
}
