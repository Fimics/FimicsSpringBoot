package com.mic.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtil {

    public static Connection getConnection() throws Exception {
        //1. 创建连接工厂（设置RabbitMQ的连接参数）；
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //主机；默认localhost
        connectionFactory.setHost("localhost");
        //连接端口；默认5672
        connectionFactory.setPort(5672);
        //虚拟主机；默认/
        connectionFactory.setVirtualHost("/");
        //用户名；默认guest
        connectionFactory.setUsername("guest");
        //密码；默认guest
        connectionFactory.setPassword("guest");

        //2. 创建连接；
        return connectionFactory.newConnection();
    }
}
