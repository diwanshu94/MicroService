package com.spring.diwanshu.UserService.repository;

import com.spring.diwanshu.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
