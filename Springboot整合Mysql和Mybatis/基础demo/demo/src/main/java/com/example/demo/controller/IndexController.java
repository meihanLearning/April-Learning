package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 首页控制器
 */
@RestController
public class IndexController {
    
    @GetMapping("/")
    public Map<String, Object> index() {
        Map<String, Object> result = new HashMap<>();
        result.put("message", "SpringBoot整合MySQL和MyBatis示例");
        result.put("api", new String[]{
            "GET /users - 获取所有用户",
            "GET /users/{id} - 获取指定ID的用户",
            "POST /users - 添加用户",
            "PUT /users/{id} - 更新用户",
            "DELETE /users/{id} - 删除用户"
        });
        return result;
    }
} 