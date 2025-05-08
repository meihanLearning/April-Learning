package com.example.demo1.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 原型作用域的Bean示例
 * 使用@Component注解标记为Spring组件
 * 使用@Scope("prototype")注解指定为原型作用域
 * 每次获取时都会创建新的实例
 */
@Component
@Scope("prototype")
public class PrototypeBean {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PrototypeBean.class);

    /**
     * 构造函数，用于观察Bean的创建时机
     */
    public PrototypeBean() {
        log.info("PrototypeBean 构造函数被调用");
    }

    /**
     * 初始化方法，使用@PostConstruct注解标记
     * 在Bean创建完成后，依赖注入完成后调用
     */
    @PostConstruct
    public void init() {
        log.info("PrototypeBean 初始化方法被调用");
    }

    /**
     * 销毁方法，使用@PreDestroy注解标记
     * 在Bean被销毁前调用
     * 注意：原型作用域的Bean的销毁方法不会被自动调用
     */
    @PreDestroy
    public void destroy() {
        log.info("PrototypeBean 销毁方法被调用");
    }

    /**
     * 业务方法
     */
    public void doSomething() {
        log.info("PrototypeBean 执行业务方法");
    }
} 