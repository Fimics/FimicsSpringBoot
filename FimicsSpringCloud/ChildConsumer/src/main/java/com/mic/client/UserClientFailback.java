package com.mic.client;

import com.mic.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFailback implements UserClient {
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("用户异常");
        return user;
    }
}
