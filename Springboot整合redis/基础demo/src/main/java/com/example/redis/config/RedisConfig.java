package com.example.redis.config;

// 导入所需的Spring注解和类
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

// @Configuration 注解表示这是一个配置类
// Spring Boot会在启动时自动加载这个配置
@Configuration
public class RedisConfig {
    
    // @Bean 注解表示这个方法将产生一个Bean（对象）
    // 这个Bean会被Spring管理，其他类可以通过@Autowired注入使用
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        // 创建RedisTemplate对象，这是操作Redis的核心类
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        
        // 设置Redis连接工厂，这个工厂是Spring Boot自动配置的
        template.setConnectionFactory(connectionFactory);
        
        // 创建String类型的序列化器
        // 序列化器的作用是将数据转换成可以存储的格式
        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        
        // 设置key的序列化方式为String
        // 这样可以方便我们在Redis客户端查看key的值
        template.setKeySerializer(stringSerializer);
        
        // 设置value的序列化方式为String
        // 实际项目中可能会使用JSON序列化器
        template.setValueSerializer(stringSerializer);
        
        // 初始化RedisTemplate的配置
        template.afterPropertiesSet();
        
        return template;
    }
} 