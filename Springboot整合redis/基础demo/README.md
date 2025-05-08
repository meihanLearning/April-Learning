# Spring Boot Redis Demo

这是一个简单的Spring Boot整合Redis的演示项目。

## 环境要求

- JDK 1.8+
- Maven 3.6+
- Redis 6.0+

## 安装步骤

1. 安装Redis（如果尚未安装）：
   ```bash
   # MacOS
   brew install redis
   
   # 启动Redis服务
   brew services start redis
   ```

2. 安装Maven（如果尚未安装）：
   ```bash
   # MacOS
   brew install maven
   ```

3. 编译项目：
   ```bash
   mvn clean install
   ```

4. 运行项目：
   ```bash
   mvn spring-boot:run
   ```

## API示例

1. 设置键值对：
   ```bash
   curl -X POST http://localhost:8080/redis/set/hello/world
   ```

2. 获取值：
   ```bash
   curl http://localhost:8080/redis/get/hello
   ```

3. 删除键：
   ```bash
   curl -X DELETE http://localhost:8080/redis/delete/hello
   ```

## 项目结构

- `RedisDemoApplication.java`: 主应用类
- `RedisConfig.java`: Redis配置类
- `RedisController.java`: REST API控制器
- `application.yml`: 应用配置文件 