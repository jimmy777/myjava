package study5;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnPoolDemo {
    public static void main(String[] args) throws NamingException, SQLException {
        ConnPool pool = new ConnPool();
        Connection conn = pool.go();
        if (conn.isValid(10)){
            System.out.println("Mysql connecting is OK.");
        }

        conn.close();
    }
}
