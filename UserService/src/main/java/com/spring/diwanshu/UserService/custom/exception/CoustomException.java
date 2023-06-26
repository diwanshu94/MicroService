package com.spring.diwanshu.UserService.custom.exception;

public class CoustomException extends  RuntimeException{

    public CoustomException(){
        super("Resource not found on Server..!!");
    }

    public CoustomException(String message){
        super(message);
    }

}
