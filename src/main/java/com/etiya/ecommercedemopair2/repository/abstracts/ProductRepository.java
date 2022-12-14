package com.etiya.ecommercedemopair2.repository.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.product.ListProductResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    // Stock sayısına göre stock alanı gelen int değerden fazla olan productlar
    List<Product> findAllProductsByStockGreaterThanOrderByStockDesc(int stock);

    // JPQL
    @Query("Select p from Product as p WHERE product_name=:name")
    Product findByName(String name);

    @Query(" select new com.etiya.ecommercedemopair2.business.dtos.response.product.AddProductResponse" +
            " (p.id,p.name,p.unitPrice,p.stock,p.category.id,co.id,p.saleCount) from Product as p inner join p.color as co" +
            " WHERE p.id= :identity")
    List<AddProductResponse> getProductById(int identity);


    List<Product> getById(int id);


    @Query("Select p from Product as p")
    Slice<Product> getAllWithSlice(Pageable pageable);

    @Query("Select new com.etiya.ecommercedemopair2.business.dtos.response.product.ListProductResponse(p.id,p.name) from Product as p")
    Page<ListProductResponse> getAllListProducts(Pageable pageable);
}
