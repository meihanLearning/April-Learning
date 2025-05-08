package com.example.classloader;

public class TestClass {
    public void sayHello() {
        System.out.println("Hello "+this.getClass().getClassLoader());
    }
} 