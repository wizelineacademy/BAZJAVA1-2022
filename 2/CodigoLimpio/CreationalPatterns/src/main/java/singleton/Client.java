package singleton;

public class Client {

    public static void main(String[] args) {
        DatabaseConfig databaseConfig = DatabaseConfig.getInstance("MySQL");
        databaseConfig.connect();
    }
}
