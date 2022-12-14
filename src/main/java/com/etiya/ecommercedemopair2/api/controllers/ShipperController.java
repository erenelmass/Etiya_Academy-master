package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.ShipperService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.shipper.AddShipperRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.country.AddCountryResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.shipper.AddShipperResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import com.etiya.ecommercedemopair2.entities.concretes.Shipper;
import com.etiya.ecommercedemopair2.repository.abstracts.ShipperRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"shippers")
public class ShipperController {
    private ShipperService shipperService;

    @Autowired
    ShipperController(ShipperService shipperService){
        this.shipperService = shipperService;
    }

    @PostMapping("/add")
    public DataResult<AddShipperResponse> addShipper(@RequestBody @Valid AddShipperRequest addShipperRequest){
        return new DataResult<AddShipperResponse>(shipperService.addShipper(addShipperRequest).getData(),true,"Başarılı");
    }

    @GetMapping("/getAll")
    public DataResult<List<Shipper>> getAll(){
        return shipperService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Shipper> getById(@RequestParam("id") int id){
        return shipperService.getById(id);
    }
    @GetMapping("/getWithPagination")
    //RequestParam: page.pageSize
    public Page<Shipper> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return shipperService.findAllWithPagination(pageable);

    }
}
