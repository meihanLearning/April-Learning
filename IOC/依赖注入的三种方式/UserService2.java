// Setter方法注入示例
public class UserService2 {
    private DatabaseService databaseService;

    // 通过setter方法注入依赖
    public void setDatabaseService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public void saveUser(String userData) {
        if (databaseService == null) {
            throw new IllegalStateException("Database service not initialized");
        }
        databaseService.save(userData);
    }

    public String getUser(String userId) {
        if (databaseService == null) {
            throw new IllegalStateException("Database service not initialized");
        }
        return databaseService.get(userId);
    }
} 