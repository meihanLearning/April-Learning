package com.example.redis;

// 导入Spring Boot相关注解
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication 是一个复合注解，包括：
// @Configuration：表明这个类是配置类
// @EnableAutoConfiguration：启用Spring Boot的自动配置机制
// @ComponentScan：自动扫描并加载符合条件的组件
@SpringBootApplication
public class RedisDemoApplication {
    // Java程序的入口方法
    public static void main(String[] args) {
        // 启动Spring Boot应用
        SpringApplication.run(RedisDemoApplication.class, args);
    }
} 