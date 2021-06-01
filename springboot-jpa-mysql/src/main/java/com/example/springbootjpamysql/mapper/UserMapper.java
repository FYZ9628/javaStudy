package com.example.springbootjpamysql.mapper;

import com.example.springbootjpamysql.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMapper extends JpaRepository<User, Integer> {
    User findById(int id);
    User findByAccount(String account);
    User findByAccountAndPassword(String account,String password);
    List<User> findAllByUsernameLike(String username);
    List<User> findAllByAccountLikeOrUsernameLike(String account, String username);
}
