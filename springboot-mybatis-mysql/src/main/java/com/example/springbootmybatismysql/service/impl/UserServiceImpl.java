package com.example.springbootmybatismysql.service.impl;

import com.example.springbootmybatismysql.domain.User;
import com.example.springbootmybatismysql.mapper.UserMapper;
import com.example.springbootmybatismysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public User findByAccount(String account) {
        return userMapper.findByAccount(account);
    }

    @Override
    public User findByAccountAndPassword(User user) {
        return userMapper.findByAccountAndPassword(user);
    }

    @Override
    public List<User> findAllByUsernameLike(String username) {
        return userMapper.findAllByUsernameLike(username);
    }

    @Override
    public List<User> findAllByAccountLikeOrUsernameLike(String keywords) {
        return userMapper.findAllByAccountLikeOrUsernameLike(keywords);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
