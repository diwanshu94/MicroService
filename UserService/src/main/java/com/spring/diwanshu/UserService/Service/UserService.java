package com.spring.diwanshu.UserService.Service;


import com.spring.diwanshu.UserService.entities.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {

    User saveUser(User user);

    User getUser(String userId);

    List<User> getAllUser();
}
