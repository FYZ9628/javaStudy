package com.example.springbootredis.service.impl;

import com.example.springbootredis.domain.User;
import com.example.springbootredis.mapper.UserMapper;
import com.example.springbootredis.redis.CastUtils;
import com.example.springbootredis.redis.RedisService;
import com.example.springbootredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    RedisService redisService;

    @Override
    public List<User> getAllUser() {
        List<User> userList;
        String key = "userList";
        Object userCache = redisService.get(key);

        if (userCache == null) {
            userList = userMapper.getAllUser();
            redisService.set(key,userList);
        } else {
            //从缓存拿回来的是 Object ，我们需要编写一个方法把它转换为 List
            userList = CastUtils.objectConvertToList(userCache, User.class);
        }
        return userMapper.getAllUser();
    }

    @Override
    public User findById(int id) {
        User user;
        String key = "userId:" + id;
        Object userCache = redisService.get(key);

        if (userCache == null) {
            user = userMapper.findById(id);
            redisService.set(key, user);
        } else {
            user = (User) userCache;
        }
        return user;
    }

    @Override
    public User findByAccount(String account) {
        User user;
        String key = "userAccount:" + account;
        Object userCache = redisService.get(key);

        if (userCache == null) {
            user = userMapper.findByAccount(account);
            redisService.set(key, user);
        } else {
            user = (User) userCache;
        }

        return user;
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
        redisService.delete("userList");
        return userMapper.addUser(user);
    }

    @Override
    public int deleteById(int id) {
        redisService.delete("userList");
        redisService.delete("userId:"+id);
        User user = userMapper.findById(id);
        String account = "";
        if (user != null) {
            account = user.getAccount();
        }
        redisService.delete("userAccount" + account);
        return userMapper.deleteById(id);
    }

    @Override
    public int updateUser(User user) {
        redisService.delete("userList");
        redisService.delete("userId:"+user.getId());
        redisService.delete("userAccount:"+user.getAccount());
        return userMapper.updateUser(user);
    }
}
