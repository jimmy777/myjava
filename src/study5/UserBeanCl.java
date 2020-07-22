package study5;

import java.sql.*;
import java.util.ArrayList;

/**
 * 操作数据库记录，即操作 Java Bean；
 * 1. 得到 ResultSet 结果集后，立刻转换为 ArrayList 集合类型，并且可以立即释放数据库资源；
 * 2. ResultSet 结果集中的每条记录都封装成 Java Bean，易于维护；
 * 3. Arraylist 保存所有的 Bean 记录，易于操作。
 */
public class UserBeanCl {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    // 页数
    private int pageCount;

    public UserBeanCl() {
        ConnDB connDB = new ConnDB();
        this.conn = connDB.getConn();
        this.ps = null;
        this.rs = null;
        this.pageCount = 0;
    }

    /**
     * 验证用户的合法性
     * - 输入用户名和密码
     *
     * @param u
     * @param p
     * @return
     * @throws SQLException
     */
    public boolean checkUser(String u, String p) throws SQLException {
        boolean b = false;
        ps = conn.prepareStatement("select passwd from users where username='" + u + "' limit 1");
        rs = ps.executeQuery();
        if (rs.next()) {
            String sPasswd = rs.getString(1);
            if (sPasswd.equals(p)) {
                b = true;
            }
        }
        close();

        return b;
    }

    /**
     * 分页功能
     * 翻页算法：select * from users where userId > (pageNo-1)*pageSize limit pageSize;
     *
     * @param pageNow  -- 当前页
     * @param pageSize -- 每页记录数
     * @return -- Bean 记录 al 集合对象
     */
    public ArrayList getResultByPage(int pageNow, int pageSize) throws SQLException {
        ArrayList<UserBean> userBeans = new ArrayList<>();

        int rowCount = 0; // 记录总数

        ps = conn.prepareStatement("SELECT COUNT(*) FROM users");

        rs = ps.executeQuery();
        if (rs.next()) {
            rowCount = rs.getInt(1);
        }

        System.out.println("[UserBeanCl::getResultByPage] row count = " + rowCount);

        if (rowCount % pageSize == 0) {
            pageCount = rowCount / pageSize;
        } else {
            pageCount = rowCount / pageSize + 1;
        }

        ps = conn.prepareStatement("select * from users where userId > (?-1)*? limit ?");
        ps.setInt(1, pageNow);
        ps.setInt(2, pageSize);
        ps.setInt(3, pageSize);

        rs = ps.executeQuery();

        // 得到 rs 结果集后，遍历存入 Bean 对象中。
        while (rs.next()) {
            UserBean userBean = new UserBean();
            userBean.setUserId(rs.getInt(1));
            userBean.setUsername(rs.getString(2));
            userBean.setPasswd(rs.getString(3));
            userBean.setEmail(rs.getString(4));
            userBean.setGrade(rs.getInt(5));
            userBean.setSex(rs.getInt(6));

            userBeans.add(userBean);
        }

        close();

        return userBeans;
    }

    /**
     * 获取页码
     * @return
     */
    public int getPageCount() {
        return this.pageCount;
    }

    /**
     * 关闭连接，释放服务器资源。
     * @throws SQLException
     */
    private void close() throws SQLException {
        if (rs != null) {
            rs.close();
            rs = null;
        }
        if (ps != null) {
            ps.close();
            ps = null;
        }
        if (conn != null) {
            conn.close();
            conn = null;
        }
    }

    /**
     * 删除用户
     * @param id -- 用户id
     * @return
     */
    public boolean delUser(String id) {
        boolean b = false;

        try {
            ps = conn.prepareStatement("DELETE FROM users WHERE userId=" + id);
            int num = ps.executeUpdate();
            if (num == 1){
                b = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return b;
    }
}
