package lk.waste_managment_system.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private Connection connection;
    private static ConnectionFactory dbConnection;

    public ConnectionFactory() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/waste";
        String userName = "root";
        String password = "";

        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnectionFactory getInstance() {
        if (dbConnection == null) {
            dbConnection = new ConnectionFactory();
        }
        return dbConnection;
    }
}
