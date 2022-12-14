package com.etiya.ecommercedemopair2.core.util.exceptions;

//İş kurallerı valid olmadığında fırlatılacak exception clası
public class BusinessException extends RuntimeException{


    public BusinessException(String message)
    {
        //errorMessage=new ErrorMessages(message);
        super(message);
    }
}
