package com.example.demo1.controller;

import com.example.demo1.beans.PrototypeBean;
import com.example.demo1.beans.SingletonBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示Bean作用域和生命周期的控制器
 */
@RestController
public class BeanDemoController {

    private static final Logger log = LoggerFactory.getLogger(BeanDemoController.class);

    @Autowired
    private SingletonBean singletonBean1;
    
    @Autowired
    private SingletonBean singletonBean2;
    
    @Autowired
    private PrototypeBean prototypeBean1;
    
    @Autowired
    private PrototypeBean prototypeBean2;

    /**
     * 基础测试端点
     * 访问地址：http://localhost:8088/test
     */
    @GetMapping("/test")
    public String test() {
        log.info("接收到测试请求");
        return "测试请求成功";
    }

    
    /**
     * 演示单例Bean的行为
     * 访问地址：http://localhost:8088/singleton
     */
    @GetMapping("/singleton")
    public String testSingleton() {
        log.info("接收到单例Bean测试请求");
        log.info("singletonBean1 实例: {}", singletonBean1);
        log.info("singletonBean2 实例: {}", singletonBean2);
        
        singletonBean1.doSomething();
        singletonBean2.doSomething();
        
        // 比较两个单例Bean的引用是否相同
        boolean isSame = singletonBean1 == singletonBean2;
        String result = "单例Bean比较结果：" + isSame;
        log.info(result);
        return result;
    }
    
    /**
     * 演示原型Bean的行为
     * 访问地址：http://localhost:8088/prototype
     */
    @GetMapping("/prototype")
    public String testPrototype() {
        log.info("接收到原型Bean测试请求");
        log.info("prototypeBean1 实例: {}", prototypeBean1);
        log.info("prototypeBean2 实例: {}", prototypeBean2);
        
        prototypeBean1.doSomething();
        prototypeBean2.doSomething();
        
        // 比较两个原型Bean的引用是否相同
        boolean isSame = prototypeBean1 == prototypeBean2;
        String result = "原型Bean比较结果：" + isSame;
        log.info(result);
        return result;
    }
} 