package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 用户数据访问接口
 */
@Mapper
public interface UserMapper {
    
    /**
     * 查询所有用户
     */
    @Select("SELECT * FROM user")
    List<User> findAll();
    
    /**
     * 根据ID查询用户
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(Integer id);
    
    /**
     * 添加用户
     */
    @Insert("INSERT INTO user(username, password, email, create_time) VALUES(#{username}, #{password}, #{email}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);
    
    /**
     * 更新用户
     */
    @Update("UPDATE user SET username = #{username}, password = #{password}, email = #{email} WHERE id = #{id}")
    int update(User user);
    
    /**
     * 删除用户
     */
    @Delete("DELETE FROM user WHERE id = #{id}")
    int delete(Integer id);
    
    /**
     * 根据用户名查询用户 (XML配置方式)
     */
    User findByUsername(String username);
    
    /**
     * 根据邮箱查询用户 (XML配置方式)
     */
    User findByEmail(String email);
    
    /**
     * 多条件分页查询 (XML配置方式)
     */
    List<User> findByCondition(Map<String, Object> params);
} 