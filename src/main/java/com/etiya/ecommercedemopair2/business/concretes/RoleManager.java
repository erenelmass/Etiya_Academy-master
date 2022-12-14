package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.RoleService;
import com.etiya.ecommercedemopair2.business.dtos.request.role.AddRoleRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.role.AddRoleResponse;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Role;
import com.etiya.ecommercedemopair2.repository.abstracts.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleManager implements RoleService {
    private RoleRepository roleRepository;
    private ModelMapperService modelMapperService;
    @Override
    public DataResult<AddRoleResponse> addRole(AddRoleRequest addRoleRequest) {
        Role role=modelMapperService.forRequest().map(addRoleRequest,Role.class);

        Role savedRole =roleRepository.save(role);

        AddRoleResponse response=
                modelMapperService.forResponse().map(savedRole,AddRoleResponse.class);
        return new SuccessDataResult<AddRoleResponse>(response,"Rol eklendi.");
    }

    @Override
    public DataResult<Role> getById(int id) {
        return new SuccessDataResult<Role>
                (this.roleRepository.findById(id).orElseThrow(),"Id'ye göre listelendi.");

    }

    @Override
    public Page<Role> findAllWithPagination(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }
}
