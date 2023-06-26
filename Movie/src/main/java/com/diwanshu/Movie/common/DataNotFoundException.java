package com.diwanshu.Movie.common;

public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(){
        super("Data not Found..!!");
    }

    public DataNotFoundException(String message){
        super(message);
    }
}
