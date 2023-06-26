package com.spring.diwanshu.UserService.custom.exception;

import com.spring.diwanshu.UserService.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CoustomException.class)
    public ResponseEntity<APIResponse> handelResourceNotFoundException(CoustomException ex){

        String message = ex.getMessage();
    APIResponse response = APIResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
    return new ResponseEntity<APIResponse>(response,HttpStatus.NOT_FOUND);
    }
}
