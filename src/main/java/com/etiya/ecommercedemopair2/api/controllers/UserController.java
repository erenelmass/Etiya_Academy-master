package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.UserService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemopair2.business.dtos.request.user.AddUserRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.user.AddUserResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import com.etiya.ecommercedemopair2.entities.concretes.User;
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
@RequestMapping(Paths.apiPrefix+"users")
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/getAll")
    public DataResult<List<User>> getAll(){
        return new SuccessDataResult<List<User>>(this.userService.getAll().getData());

    }

    @GetMapping("/getById")
    public DataResult<User> getById(@PathVariable int id){
        return new SuccessDataResult<User>(this.userService.getById(id).getData());

    }
    @PostMapping("/add")
    public DataResult<AddUserResponse> addUser(@RequestBody @Valid AddUserRequest addUserRequest) {
        return new DataResult<AddUserResponse>(userService.addUser(addUserRequest).getData(),true,"Başarılı");
    }

    @GetMapping("/getWithPagination")
    //RequestParam: page.pageSize
    public Page<User> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return userService.findAllWithPagination(pageable);

    }
}
