package com.example.springbootmybatismysql.controller;

import com.example.springbootmybatismysql.domain.User;
import com.example.springbootmybatismysql.result.Search;
import com.example.springbootmybatismysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/getAllUser")
    public List<User> getAllUser() throws Exception {
        return userService.getAllUser();
    }

    @PostMapping("/api/findById")
    public User findById(int id) throws Exception {
        return userService.findById(id);
    }

    @PostMapping("/api/findByAccount")
    public User findByAccount(@RequestBody Search s) throws Exception {
        return userService.findByAccount(s.getKeywords());
    }

    @PostMapping("/api/findByAccountAndPassword")
    public User findByAccountAndPassword(@RequestBody User user) throws Exception {
        return userService.findByAccountAndPassword(user);
    }

    @PostMapping("/api/findAllByUsernameLike")
    public  List<User> findAllByUsernameLike(@RequestBody Search s) throws Exception {
        return userService.findAllByUsernameLike(s.getKeywords());
    }

    @PostMapping("/api/findAllByAccountLikeOrUsernameLike")
    public List<User> findAllByAccountLikeOrUsernameLike(@RequestBody Search s) throws Exception {
        return userService.findAllByAccountLikeOrUsernameLike(s.getKeywords());
    }

    @PostMapping("/api/addUser")
    public User addUser(@RequestBody User user) throws Exception {
        User user1 = userService.findByAccount(user.getAccount());
        if (user1 != null){
            return null;
        }else {
            userService.addUser(user);
            return user;
        }
    }

    @PostMapping("/api/updateUser")
    public User updateUser(@RequestBody User user) throws Exception {
        User user1 = userService.findByAccount(user.getAccount());
        if (user1 != null){
            userService.updateUser(user);
            return user;
        }else {
            return null;
        }
    }

    @PostMapping("/api/deleteUser")
    public User deleteUser(@RequestBody User user) throws Exception {
        User user1 = userService.findByAccount(user.getAccount());
        if (user1 != null){
            userService.deleteById(user.getId());
            return user;
        }else {
            return null;
        }
    }


}
