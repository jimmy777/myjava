package study5;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnPool {
    Connection ct;
    Context context;

    public ConnPool() throws NamingException {
         context = new InitialContext();
         ct = null;
    }

    public Connection go() throws NamingException, SQLException {
        DataSource ds = (DataSource) context.lookup("java:comp/env/mysite");
        ct = ds.getConnection();
        return ct;
    }
}
