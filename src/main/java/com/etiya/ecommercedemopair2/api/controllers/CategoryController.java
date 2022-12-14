package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Category;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
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
@RequestMapping(Paths.apiPrefix+"categories")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    CategoryController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @GetMapping("/getall")
    public DataResult<List<Category>> getAll() {

        return this.categoryService.getAll();
    }

    @GetMapping("/geybyid")
    public DataResult<Category> getById(@RequestParam int categoryId) {

        return this.categoryService.getById(categoryId);
    }

    @GetMapping("get-by-name")
    public DataResult<Category> getByName(@RequestParam("name") String name) {

        return categoryService.getByName(name);
    }

    @GetMapping("custom-get-by-name")
    public DataResult<Category> customGetByName(@RequestParam("name") String name) {

        return categoryService.customGetByName(name);
    }

    //client
    //server
    //DTO: Data Transfer Object
    //AddCategory : name, type
    @PostMapping("/add")
    public DataResult<AddCategoryResponse> addCategory(@RequestBody @Valid AddCategoryRequest addCategoryRequest){
        return new DataResult<AddCategoryResponse>(categoryService.addCategory(addCategoryRequest).getData(),true,"Başarılı") ;

    }

    @GetMapping("/getWithPagination")
    //RequestParam: page.pageSize
    public Page<Category> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return categoryService.findAllWithPagination(pageable);

    }
}
