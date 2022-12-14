package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.city.GetAllCityResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.city.ListCityResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.product.ListProductResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.City;
import com.etiya.ecommercedemopair2.entities.concretes.District;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CityService {
    DataResult<AddCityResponse> addCity (AddCityRequest addCityRequest);
    DataResult<City> getById(int id);

    DataResult<List<GetAllCityResponse>> getAllCity();

    Page<City> findAllWithPagination(Pageable pageable);

    Page<ListCityResponse> findAllWithPaginationDto(Pageable pageable);
}
