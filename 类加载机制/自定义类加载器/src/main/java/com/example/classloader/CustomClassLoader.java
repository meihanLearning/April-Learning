package com.example.classloader;

import java.io.*;

public class CustomClassLoader extends ClassLoader {
    private String classPath;

    public CustomClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            // 获取类文件的字节数组
            byte[] classData = getClassData(className);
            if (classData == null) {
                throw new ClassNotFoundException();
            }
            // 将字节数组转换为Class对象
            return defineClass(className, classData, 0, classData.length);
        } catch (IOException e) {
            throw new ClassNotFoundException();
        }
    }

    private byte[] getClassData(String className) throws IOException {
        // 首先将类名转换为文件路径
        String path = classPath + File.separatorChar 
            + className.replace('.', File.separatorChar) + ".class";
        // 读取字节数据
        try (InputStream ins = new FileInputStream(path);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        }
    }
} 