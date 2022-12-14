package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.district.AddDistrictRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.district.AddDistrictResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.district.ListDistrictResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.product.ListProductResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.District;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DistrictService {

    DataResult<AddDistrictResponse> addDistrict (AddDistrictRequest addDistrictRequest);

    DataResult<District> getById(int id);

    Page<District> findAllWithPagination(Pageable pageable);

    Page<ListDistrictResponse> findAllWithPaginationDto(Pageable pageable);
}
