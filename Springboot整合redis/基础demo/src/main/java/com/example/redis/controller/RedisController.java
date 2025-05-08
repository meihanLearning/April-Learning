package com.example.redis.controller;

// 导入所需的Spring注解和类
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

// @RestController 注解表示这是一个REST API控制器
// 它会自动将返回值转换为JSON或文本格式
@RestController
// @RequestMapping 定义了这个控制器的基础URL路径
@RequestMapping("/redis")
public class RedisController {

    // @Autowired 注解表示自动注入RedisTemplate对象
    // 这个对象是由RedisConfig类中的@Bean方法创建的
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // @PostMapping 表示这个方法处理POST请求
    // {key}和{value}是URL路径变量，例如：/redis/set/name/meihan
    @PostMapping("/set/{key}/{value}")
    // @PathVariable 注解将URL中的变量映射到方法参数
    public String set(@PathVariable String key, @PathVariable String value) {
        // 使用RedisTemplate存储键值对
        // opsForValue()返回操作Redis字符串的对象
        redisTemplate.opsForValue().set(key, value);
        return "Successfully set " + key + " to " + value;
    }

    // @GetMapping 表示这个方法处理GET请求
    // 用于获取Redis中的值
    @GetMapping("/get/{key}")
    public String get(@PathVariable String key) {
        // 获取键对应的值
        Object value = redisTemplate.opsForValue().get(key);
        // 如果值存在则返回，否则返回"Key not found"
        return value != null ? value.toString() : "Key not found";
    }

    // @DeleteMapping 表示这个方法处理DELETE请求
    // 用于删除Redis中的键值对
    @DeleteMapping("/delete/{key}")
    public String delete(@PathVariable String key) {
        // delete方法返回布尔值，表示删除是否成功
        Boolean result = redisTemplate.delete(key);
        // 根据删除结果返回相应消息
        return result != null && result ? "Successfully deleted " + key : "Key not found";
    }
} 