// 接口注入示例
public class UserService3 implements DatabaseServiceInjector {
    private DatabaseService databaseService;

    // 通过接口方法注入依赖
    @Override
    public void injectDatabaseService(DatabaseService databaseService) {
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