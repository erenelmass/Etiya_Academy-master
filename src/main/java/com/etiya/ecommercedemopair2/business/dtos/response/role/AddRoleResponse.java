package com.etiya.ecommercedemopair2.business.dtos.response.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddRoleResponse {
    private int id;
    private String roleName;
}
