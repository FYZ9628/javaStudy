package com.example.springbootjpamysql.service.impl;

import com.example.springbootjpamysql.domain.User;
import com.example.springbootjpamysql.mapper.UserMapper;
import com.example.springbootjpamysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.findAll();
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
    public User findByAccountAndPassword(String account, String password) {
        return userMapper.findByAccountAndPassword(account,password);
    }

    @Override
    public List<User> findAllByUsernameLike(String keywords) {
        return userMapper.findAllByUsernameLike('%' + keywords + '%');
    }

    @Override
    public List<User> findAllByAccountLikeOrUsernameLike(String keywords) {
        return userMapper.findAllByAccountLikeOrUsernameLike('%' + keywords + '%','%' + keywords + '%');
    }

    @Override
    public void deleteById(int id) {
        userMapper.deleteById(id);
    }

    @Override
    public User add(User user) {
        return userMapper.save(user);
    }

    @Override
    public User update(User user) {
        return userMapper.save(user);
    }
}
