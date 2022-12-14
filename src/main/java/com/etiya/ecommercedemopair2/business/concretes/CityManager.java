package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.CityService;
import com.etiya.ecommercedemopair2.business.abstracts.DistrictService;
import com.etiya.ecommercedemopair2.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.city.GetAllCityResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.city.ListCityResponse;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair2.entities.concretes.City;
import com.etiya.ecommercedemopair2.repository.abstracts.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityManager implements CityService {

    private CityRepository cityRepository;
    private DistrictService districtService;
    private ModelMapperService modelMapperService;
    @Override
    public DataResult<AddCityResponse> addCity(AddCityRequest addCityRequest) {
        City city=modelMapperService.forRequest().map(addCityRequest,City.class);
        City savedCity = cityRepository.save(city);

        AddCityResponse response=
                modelMapperService.forResponse().map(savedCity,AddCityResponse.class);
        return new SuccessDataResult<AddCityResponse>(response,"Şehir eklendi");
    }

    @Override
    public DataResult<City> getById(int id) {

        return new SuccessDataResult<City>(cityRepository.findById(id).orElseThrow(),"Id'ye göre listelendi.");

    }

    @Override
    public DataResult<List<GetAllCityResponse>> getAllCity() {
        return new SuccessDataResult<>(cityRepository.getAllCity());

    }

    @Override
    public Page<City> findAllWithPagination(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public Page<ListCityResponse> findAllWithPaginationDto(Pageable pageable) {
        return cityRepository.getAllListCity(pageable);
    }
}
