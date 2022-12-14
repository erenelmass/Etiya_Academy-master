package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.AddressService;
import com.etiya.ecommercedemopair2.business.abstracts.UserService;
import com.etiya.ecommercedemopair2.business.dtos.request.user.AddUserRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.user.AddUserResponse;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Address;
import com.etiya.ecommercedemopair2.entities.concretes.User;
import com.etiya.ecommercedemopair2.repository.abstracts.AddressRepository;
import com.etiya.ecommercedemopair2.repository.abstracts.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserManager implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressService addressService;
    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(userRepository.findAll(),"Kullanıcılar Listelendi.");

    }

    @Override
    public DataResult<User> getById(int id) {
        return new SuccessDataResult<User>
                (this.userRepository.findById(id).orElseThrow(),"Id'ye göre listelendi.");

    }

//    @Override
//    public List<User> getByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    @Override
//    public User getByFirst_name(String name) {
//        return userRepository.findByFirst_name(name);
//    }

    @Override
    public DataResult<AddUserResponse> addUser(AddUserRequest addUserRequest) {
        User user=modelMapperService.forRequest().map(addUserRequest,User.class);

        User savedUser = userRepository.save(user);

        AddUserResponse response =
                modelMapperService.forResponse().map(savedUser,AddUserResponse.class);
        return new SuccessDataResult<AddUserResponse>(response,"Kullanıcı eklendi.");
    }

    @Override
    public Page<User> findAllWithPagination(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    private Address checkIfAddressExistsById(int address_id) {
        Address currentAddress = this.addressRepository.findById(address_id).orElseThrow();
        return currentAddress;
    }
}
