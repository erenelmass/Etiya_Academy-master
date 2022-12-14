package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.user.AddUserRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.user.AddUserResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import com.etiya.ecommercedemopair2.entities.concretes.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();

    DataResult<User> getById(int id);

//    List<User> getByEmail(String email);
//
//    User getByFirst_name(String name);

    DataResult<AddUserResponse> addUser(AddUserRequest addUserRequest);
    Page<User> findAllWithPagination(Pageable pageable);
}
