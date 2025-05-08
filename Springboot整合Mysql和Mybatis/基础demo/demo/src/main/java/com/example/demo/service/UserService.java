package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

/**
 * 用户服务接口
 */
public interface UserService {
    
    /**
     * 查询所有用户
     */
    List<User> findAll();
    
    /**
     * 根据ID查询用户
     */
    User findById(Integer id);
    
    /**
     * 添加用户
     */
    int insert(User user);
    
    /**
     * 更新用户
     */
    int update(User user);
    
    /**
     * 删除用户
     */
    int delete(Integer id);
} 