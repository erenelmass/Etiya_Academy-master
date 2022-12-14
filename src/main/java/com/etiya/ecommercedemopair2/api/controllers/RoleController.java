package com.etiya.ecommercedemopair2.api.controllers;

import com.etiya.ecommercedemopair2.business.abstracts.RoleService;
import com.etiya.ecommercedemopair2.business.constants.Paths;
import com.etiya.ecommercedemopair2.business.dtos.request.role.AddRoleRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.role.AddRoleResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Product;
import com.etiya.ecommercedemopair2.entities.concretes.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(Paths.apiPrefix+"roles")
public class RoleController {
    private RoleService roleService;

    @Autowired
    RoleController(RoleService roleService){
        this.roleService=roleService;
    }

    @PostMapping("/add")
    public DataResult<AddRoleResponse> addRole (@RequestBody @Valid AddRoleRequest addRoleRequest){
        return new DataResult<AddRoleResponse>(roleService.addRole(addRoleRequest).getData(),true,"Başarılı");
    }
    @GetMapping("/getById")
    public DataResult<Role> getByIdPath(@RequestParam("id") int id){
        return roleService.getById(id);
    }
    @GetMapping("/getWithPagination")
    //RequestParam: page.pageSize
    public Page<Role> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return roleService.findAllWithPagination(pageable);

    }
}
