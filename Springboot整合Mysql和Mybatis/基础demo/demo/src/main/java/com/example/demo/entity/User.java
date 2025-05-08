package com.example.demo.entity;

import java.util.Date;

/**
 * 用户实体类
 */
public class User {
    
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Date createTime;
    
    // 无参构造方法
    public User() {
    }
    
    // 带参构造方法
    public User(Integer id, String username, String password, String email, Date createTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createTime = createTime;
    }
    
    // Getter 和 Setter 方法
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                '}';
    }
} 