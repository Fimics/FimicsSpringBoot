package com.mic.controller;


import com.mic.client.UserClient;
import com.mic.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cf")
public class ConsumerFeignController {

    @Qualifier("userClientFailback")
    @Autowired
    private UserClient userClient;

    @GetMapping("/{id}")
    public User queryById(@PathVariable Long id){
        return userClient.queryById(id);
    }
}
