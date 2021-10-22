package com.mic.controller;

import com.mic.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "defaultFallback") //默认降级方法，使用在类上
public class ConsumerController {

    @Autowired
    private RestTemplate template;

    @Autowired
    private DiscoveryClient discoveryClient;

//    @GetMapping("/{id}")
//    public User queryById(@PathVariable Long id){
////        String url = "http://localhost:9091/user/8";
//        StringBuffer sb = new StringBuffer();
//        //获取Eureka 中注册的user-servic实例
//        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("user-service");
//        ServiceInstance serviceInstance = serviceInstances.get(0);
//        System.out.println("port--->"+serviceInstance.getPort());
//        sb.append("http://")
//                .append(serviceInstance.getHost())
//                .append(":")
//                .append(serviceInstance.getPort())
//                .append("/user/")
//                .append(id);
//        String url =sb.toString();
//        System.out.println("url =--->"+url);
//        return template.getForObject(url,User.class);
//    }

    @GetMapping("/{id}")
//    @HystrixCommand(fallbackMethod = "queryByIdFallback") //服务降级方法
    @HystrixCommand
    public String queryById(@PathVariable Long id){
        if (id == 1) {
            throw new RuntimeException("太忙了");
        }
        String url="http://user-service/user/"+id;
        return template.getForObject(url,String.class);
    }

    public String queryByIdFallback(Long id){
//        log.error("查询用户信息失败。id：{}", id);
        return "对不起，网络太拥挤了！";
    }

    public String defaultFallback(){
        return "默认提示：对不起，网络太拥挤了！";
    }
}
