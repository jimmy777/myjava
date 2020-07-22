package study5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接数据库的类
 */
public class ConnDB {
    private Connection ct = null;

    public Connection getConn() {
        // 1. 连接数据库 Connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ct = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useSSL=false&serverTimezone=UTC", "root", "passw0rd");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return ct;
    }
}
