package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    /**
     * 查询所有用户
     */
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }
    
    /**
     * 根据ID查询用户
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }
    
    /**
     * 添加用户
     */
    @PostMapping
    public User insert(@RequestBody User user) {
        // 设置创建时间
        user.setCreateTime(new Date());
        userService.insert(user);
        return user;
    }
    
    /**
     * 更新用户
     */
    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id);
        userService.update(user);
        return user;
    }
    
    /**
     * 删除用户
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        userService.delete(id);
        return "删除成功";
    }
} 