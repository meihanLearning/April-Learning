# SpringBoot整合MySQL和MyBatis示例项目

这是一个演示如何在Spring Boot项目中整合MySQL和MyBatis的示例项目。

## 项目结构

```
demo
├── src/main/java
│   └── com/example/demo
│       ├── controller     # 控制器层
│       ├── entity         # 实体类
│       ├── mapper         # 数据访问层接口
│       ├── service        # 服务层接口
│       │   └── impl       # 服务层实现类
│       └── DemoApplication.java  # 主启动类
├── src/main/resources
│   ├── mapper           # MyBatis XML映射文件目录
│   ├── sql              # SQL脚本目录
│   ├── static           # 静态资源目录
│   ├── templates        # 模板目录
│   └── application.properties  # 项目配置文件
└── pom.xml            # Maven依赖配置文件
```

## 技术栈

- Spring Boot 3.4.5
- MySQL 8.0
- MyBatis 3.0.4
- Java 17

## 运行步骤

1. 确保已安装MySQL数据库，并创建数据库和表
   - 导入 `/src/main/resources/sql/user.sql` 脚本

2. 修改 `application.properties` 中的数据库连接信息
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
   spring.datasource.username=root
   spring.datasource.password=root
   ```

3. 运行项目
   ```bash
   mvn spring-boot:run
   ```

4. 在浏览器中访问：`http://localhost:8080`

## API接口

| 请求方法 | URL | 说明 |
|---------|-----|------|
| GET | /users | 获取所有用户 |
| GET | /users/{id} | 获取指定ID的用户 |
| POST | /users | 添加用户 |
| PUT | /users/{id} | 更新用户 |
| DELETE | /users/{id} | 删除用户 |

## 示例请求

### 添加用户
```bash
curl -X POST -H "Content-Type: application/json" -d '{"username":"test","password":"123456","email":"test@example.com"}' http://localhost:8080/users
```

### 查询所有用户
```bash
curl http://localhost:8080/users
```

## MyBatis使用方式

本项目演示了两种MyBatis的使用方式：
1. **注解方式**：在`UserMapper.java`中直接使用`@Select`、`@Insert`等注解定义SQL语句
2. **XML配置方式**：在`mapper/UserMapper.xml`中定义SQL语句，并在`UserMapper.java`接口中声明对应方法

## 学习要点

1. Spring Boot配置MySQL数据源
2. MyBatis的注解方式和XML配置方式
3. 实体类、Mapper、Service和Controller的分层设计
4. RESTful API的设计和实现 