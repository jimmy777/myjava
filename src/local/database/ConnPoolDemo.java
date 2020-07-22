package local.database;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnPoolDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String res = Conn();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h2>schema</h2>");
        out.println("<p>" + res + "</p>");
    }

    public static String Conn() {
        String result = "";
        try {
            Context initCtx = new InitialContext();
            DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/mysite");

            try {
                Connection conn = ds.getConnection();
                System.out.println("****** conn=" + conn);

                Statement stmt = conn.createStatement();
                String sql = "select username from users";
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String name = rs.getString(1);
                    result = result + "|" + name;
                }

                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            return result;
        }

    }

}
