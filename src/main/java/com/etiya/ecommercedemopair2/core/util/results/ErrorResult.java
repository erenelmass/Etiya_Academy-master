package com.etiya.ecommercedemopair2.core.util.results;

public class ErrorResult extends Result{
    public ErrorResult(){
        super(false);
    }

    public ErrorResult(String message){
        super(false,message);
    }
}
