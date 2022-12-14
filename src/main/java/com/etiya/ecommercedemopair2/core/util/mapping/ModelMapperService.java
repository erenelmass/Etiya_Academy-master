package com.etiya.ecommercedemopair2.core.util.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    //Add,Delete and Update
    ModelMapper forRequest();

    //Get,GetAll
    ModelMapper forResponse();

    ModelMapper getMapper();
}
