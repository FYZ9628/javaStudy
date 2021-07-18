package com.example.springbootredis.service;

import com.example.springbootredis.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User findById(int id);
    User findByAccount(String account);
    User findByAccountAndPassword(User user);
    List<User> findAllByUsernameLike(String username);
    List<User> findAllByAccountLikeOrUsernameLike(String keywords);
    int addUser(User user);
    int deleteById(int id);
    int updateUser(User user);
}
