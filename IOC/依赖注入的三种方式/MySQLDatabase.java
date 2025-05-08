public class MySQLDatabase implements DatabaseService {
    @Override
    public void save(String data) {
        System.out.println("Saving data to MySQL: " + data);
    }

    @Override
    public String get(String id) {
        return "Data from MySQL for ID: " + id;
    }
} 