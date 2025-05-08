package com.example.classloader;

public class ClassLoaderTest {
    public static void main(String[] args) {
        try {
            // 创建自定义类加载器实例
            CustomClassLoader loader = new CustomClassLoader("target/classes");
            
            // 使用自定义类加载器加载类
            Class<?> testClass = loader.loadClass("com.example.classloader.TestClass");
            
            // 创建实例并调用方法
            Object instance = testClass.newInstance();
            testClass.getMethod("sayHello").invoke(instance);
            
            // 打印类加载器层次结构
            ClassLoader currentLoader = testClass.getClassLoader();
            System.out.println("\n类加载器层次:");
            while (currentLoader != null) {
                System.out.println(currentLoader);
                currentLoader = currentLoader.getParent();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 