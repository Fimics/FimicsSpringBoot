package com.mic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer //开启动ConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {

        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
