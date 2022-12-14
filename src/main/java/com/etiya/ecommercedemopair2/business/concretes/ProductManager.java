package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair2.business.abstracts.ColorService;
import com.etiya.ecommercedemopair2.business.abstracts.ProductService;
import com.etiya.ecommercedemopair2.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.product.ListProductResponse;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import com.etiya.ecommercedemopair2.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private ProductRepository productRepository;
    private CategoryService categoryService;
    private ColorService colorService;
    private ModelMapperService modelMapperService;

    //DEPENDENCY INJECTION

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>
                (this.productRepository.findAll(),"Data listelendi.");
    }


    @Override
    public DataResult<Product> getById(int id) {
        return new SuccessDataResult<Product>
                (this.productRepository.findById(id).orElseThrow());

    }



    @Override
    public DataResult<List<Product>> getAllProductsByStockGreaterThanOrderByStockDesc(int stock) {
        return new SuccessDataResult<List<Product>>
                (this.productRepository.findAllProductsByStockGreaterThanOrderByStockDesc(stock));
    }

    public DataResult<List<AddProductResponse>> getProductById (int id){
        return new SuccessDataResult<List<AddProductResponse>>
                (this.productRepository.getProductById(id));
    }



    @Override
    public DataResult<AddProductResponse> addProduct(AddProductRequest addProductRequest) {

        Product product=modelMapperService.forRequest().map(addProductRequest,Product.class);

        Product savedProduct=productRepository.save(product);

        AddProductResponse response=
                modelMapperService.forResponse().map(savedProduct, AddProductResponse.class);
        return new SuccessDataResult<AddProductResponse>(response,"Ürün eklendi.");

    }

    @Override
    public Page<Product> findAllWithPagination(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Slice<Product> findAllWithSlice(Pageable pageable) {
        return productRepository.getAllWithSlice(pageable);
    }

    @Override
    public Page<ListProductResponse> findAllWithPaginationDto(Pageable pageable) {
        return productRepository.getAllListProducts(pageable);
    }


}
