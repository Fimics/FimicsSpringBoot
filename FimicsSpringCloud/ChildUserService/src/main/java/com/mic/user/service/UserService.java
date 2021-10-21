package com.mic.user.service;


import com.mic.user.mapper.UserMapper;
import com.mic.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(long id){
        return userMapper.selectByPrimaryKey(id);
    }
}
