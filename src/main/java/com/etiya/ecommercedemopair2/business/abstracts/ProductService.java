package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.product.ListProductResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>>  getAll();

    DataResult<Product> getById(int id);

    DataResult<List<Product>> getAllProductsByStockGreaterThanOrderByStockDesc(int stock);

    DataResult<List<AddProductResponse>> getProductById(int id);

    DataResult<AddProductResponse> addProduct (AddProductRequest addProductRequest);

    Page<Product> findAllWithPagination(Pageable pageable);

    Slice<Product> findAllWithSlice(Pageable pageable);

    Page<ListProductResponse> findAllWithPaginationDto(Pageable pageable);
}
