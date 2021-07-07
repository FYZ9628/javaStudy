package com.example.springbootmybatismysql.mapper;

import com.example.springbootmybatismysql.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
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
