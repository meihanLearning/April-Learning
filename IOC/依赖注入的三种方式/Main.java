public class Main {
    public static void main(String[] args) {
        // 创建数据库服务实例
        DatabaseService databaseService = new MySQLDatabase();

        // 1. 构造函数注入示例
        System.out.println("=== 构造函数注入示例 ===");
        UserService1 service1 = new UserService1(databaseService);
        service1.saveUser("User1 Data");
        System.out.println(service1.getUser("1"));

        // 2. Setter方法注入示例
        System.out.println("\n=== Setter方法注入示例 ===");
        UserService2 service2 = new UserService2();
        service2.setDatabaseService(databaseService);
        service2.saveUser("User2 Data");
        System.out.println(service2.getUser("2"));

        // 3. 接口注入示例
        System.out.println("\n=== 接口注入示例 ===");
        UserService3 service3 = new UserService3();
        service3.injectDatabaseService(databaseService);
        service3.saveUser("User3 Data");
        System.out.println(service3.getUser("3"));
    }
} 