package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair2.business.constants.Messages;
import com.etiya.ecommercedemopair2.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemopair2.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.core.util.messages.MessagesService;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Category;
import com.etiya.ecommercedemopair2.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;

    private MessageSource messageSource;

    private MessagesService messagesService;


    @Override
    public DataResult<List<Category>> getAll() {

        return new SuccessDataResult<List<Category>>
                (this.categoryRepository.findAll(),"Kategori Listelendi.");

    }

    @Override
    public DataResult<Category> getById(int categoryId) {
        return new SuccessDataResult<Category>
                (this.categoryRepository.findById(categoryId).orElseThrow(),"Id'ye göre listelendi.");
    }

    @Override
    public DataResult<Category> getByName(String name) {

        return new SuccessDataResult<Category>
                (categoryRepository.findByName(name),"İsme göre listelendi");

    }

    @Override
    public DataResult<Category> customGetByName(String name) {

        return new SuccessDataResult<Category>
                (categoryRepository.customFindByName(name));
    }

    //JPA Repository Save methodu, eklenen veriyi geri döner
    @Override
    public DataResult<AddCategoryResponse> addCategory(AddCategoryRequest addCategoryRequest) {

        Category category =modelMapperService.forRequest().map(addCategoryRequest,Category.class);
        categoryCanNotExistWithSameName(addCategoryRequest.getName());
        Category savedCategory = categoryRepository.save(category);

        //MAPPING=> Category = addcategoryresponse
        AddCategoryResponse response =
                modelMapperService.forResponse().map(savedCategory,AddCategoryResponse.class);
        return new SuccessDataResult<AddCategoryResponse>(response,"Kategori eklendi.");
        //
    }

    @Override
    public Page<Category> findAllWithPagination(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    private void categoryCanNotExistWithSameName(String name){
            boolean isExists = categoryRepository.existsCategoryByName(name);
            if(isExists){
                throw new BusinessException(
                        messagesService.Messages(
                                Messages.Category.CategoryExistWithSameName));
            }


    }

}
