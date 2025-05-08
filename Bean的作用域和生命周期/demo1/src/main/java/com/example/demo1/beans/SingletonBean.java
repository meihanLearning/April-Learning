package com.example.demo1.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 单例作用域的Bean示例
 * 使用@Component注解标记为Spring组件
 * 默认情况下，Spring中的Bean都是单例的
 */
@Component
public class SingletonBean {


    private static final Logger log = org.slf4j.LoggerFactory.getLogger(SingletonBean.class);

    /**
     * 构造函数，用于观察Bean的创建时机
     */
    public SingletonBean() {
        log.info("SingletonBean 构造函数被调用");
    }

    /**
     * 初始化方法，使用@PostConstruct注解标记
     * 在Bean创建完成后，依赖注入完成后调用
     */
    @PostConstruct
    public void init() {
        log.info("SingletonBean 初始化方法被调用");
    }

    /**
     * 销毁方法，使用@PreDestroy注解标记
     * 在Bean被销毁前调用
     */
    @PreDestroy
    public void destroy() {
        log.info("SingletonBean 销毁方法被调用");
    }

    /**
     * 业务方法
     */
    public void doSomething() {
        log.info("SingletonBean 执行业务方法");
    }
} 