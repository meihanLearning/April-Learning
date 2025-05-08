package com.example.demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring Boot应用程序的主类
 * 用于启动整个应用程序
 */
@SpringBootApplication
public class Demo1Application {
    
    private static final Logger log = LoggerFactory.getLogger(Demo1Application.class);
    
    public static void main(String[] args) {
        log.info("开始启动应用程序...");
        ConfigurableApplicationContext context = SpringApplication.run(Demo1Application.class, args);
        log.info("应用程序启动完成，当前激活的Bean数量: {}", context.getBeanDefinitionCount());
    }
} 