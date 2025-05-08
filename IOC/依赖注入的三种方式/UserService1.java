// 构造函数注入示例
public class UserService1 {
    private final DatabaseService databaseService;

    // 通过构造函数注入依赖
    public UserService1(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public void saveUser(String userData) {
        databaseService.save(userData);
    }

    public String getUser(String userId) {
        return databaseService.get(userId);
    }
} 