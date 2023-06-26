package com.spring.diwanshu.UserService.controller;

import com.spring.diwanshu.UserService.Service.UserService;
import com.spring.diwanshu.UserService.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user){

      User response =   userService.saveUser(user);

      return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") String userId){

        User response = userService.getUser(userId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser(){

        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }
}
