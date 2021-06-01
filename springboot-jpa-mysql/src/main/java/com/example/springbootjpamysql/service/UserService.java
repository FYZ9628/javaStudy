package com.example.springbootjpamysql.service;

import com.example.springbootjpamysql.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User findById(int id);
    User findByAccount(String account);
    User findByAccountAndPassword(String account, String password);
    List<User> findAllByUsernameLike(String keywords);
    List<User> findAllByAccountLikeOrUsernameLike(String keywords);
    void deleteById(int id);
    User add(User user);
    User update(User user);

}
