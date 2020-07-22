package study4;

import java.sql.*;

/**
 * mysql 数据库操作
 */
public class DBConn {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/demo?useSSL=false&serverTimezone=UTC";

    static final String USER = "root";
    static final String PASS = "passw0rd";

    static Connection conn;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        // 加载驱动类。
        Class.forName(JDBC_DRIVER);
        System.out.println("----- 数据库驱动加载成功。");

        // 由驱动去创建连接，并返回一个 Connection 对象。
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("----- 数据库连接成功。");

        return conn;
    }

    /**
     *
     * 查询所有记录
     * @throws SQLException
     * @throws ClassNotFoundException
     *
     * 利用 Statement 对象进行简单 SQL 查询并显示 ResultSet 对象结果集。
     */
    public static void showAllCountry() throws SQLException, ClassNotFoundException {

        Statement stmt = conn.createStatement();
        String sql = "SELECT name, country, alexa FROM websites";
        ResultSet rs = stmt.executeQuery(sql);

//        boolean next = rs.next();
        while (rs.next()) {
            String name = rs.getString("name");
            String country = rs.getString("country");
            int alexa = rs.getInt("alexa");

            System.out.println(name + "[" + country + "]\t" + alexa);
        }

        rs.close();
        stmt.close();
    }

    /**
     *
     * 查询记录
     * @throws SQLException
     *
     * 利用 PreparedStatement 对象，动态生成查询对象，并显示 ResultSet 结果集。
     */
    public static void showDataOfCN() throws SQLException {

        String sql = "SELECT name, country FROM websites WHERE country=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "CN");

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            String country = rs.getString("country");

            System.out.println(name + "[" + country + "]");
        }

        rs.close();
        ps.close();
    }

    /**
     *
     * 插入记录
     * @throws SQLException
     *
     * 利用 PreparedStatement 对象的 executeUpdate() 方法来插入记录；
     * 注意，表中 auto_increment 的字段，用 default 来赋值。
     */
    public static void insertData() throws SQLException {
        String sql = "INSERT INTO websites VALUES (DEFAULT,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "Baidu");
        ps.setString(2, "http://www.baidu.com");
        ps.setInt(3, 10);
        ps.setString(4, "CN");

        ps.executeUpdate();
        ps.close();
    }

    /**
     *
     * 更新记录
     * @throws SQLException
     *
     * 利用 PreparedStatement 对象的 executeUpdate() 来执行更新操作；
     */
    public static void updateData() throws SQLException {
        String sql = "UPDATE websites SET name=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,"Taobao");
        ps.setInt(2,2);

        ps.executeUpdate();
        ps.close();
    }

    /**
     *
     * 删除记录
     * @throws SQLException
     *
     * 利用 PreparedStatement 对象的 executeUpdate() 来执行删除操作；
     */
    public static void deleteData() throws SQLException {
        String sql = "DELETE FROM websites where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, 4);

        ps.executeUpdate();
        ps.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        DBConn dbConn = new DBConn();
        conn = dbConn.getConnection();

//        showAllCountry();
//        insertData();
//        updateData();
//        deleteData();
        showDataOfCN();

        // 关闭连接，并释放资源。
        conn.close();
    }
}
