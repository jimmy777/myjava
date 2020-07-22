package study5;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


/**
 * 1. GET、POST 表单处理；
 * 2. MySQL 数据库操作；
 * 3. Session 操作；
 * - session 可以看做内存表，存 key-value 数据；
 * - 同一用户页面之间可以通过 session 共享数据；
 * - 不同用户的 session 空间相互独立，互不能访问（即 session ID 不同）；
 * 4. 分页操作
 * 5. cookie 操作
 * 6. ServletContext 操作
 */
public class LoginCl extends HttpServlet {

    /**
     * 获取文件中的 times 值；
     * 将 times 值加载到 sc 中；
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        try {
            // 读取文件
            FileReader fr = new FileReader("e:\\myCount.txt");
            BufferedReader br = new BufferedReader(fr);
            String sCount = br.readLine();
            br.close();
            fr.close();
            System.out.println("[LoginCl::init] read from myCount.txt count=" + sCount);

            // 将 count 值写入 ServletContext 对象
            this.getServletContext().setAttribute("times", sCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1. 获取 sc 中的 times 值；
     * 2. 将 times 值写入文件保存。
     */
    @Override
    public void destroy() {
        // 从 sc 获取 times 值
        String sCount = String.valueOf(this.getServletContext().getAttribute("times").toString());
        try {
            // 写入文件
            FileWriter fw = new FileWriter("e:\\myCount.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.valueOf(sCount));
            bw.close();
            fw.close();
            System.out.println("[LoginCl::destroy] write to myCount.txt count=" + sCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // ---------------------
        // Post 方法，获取值写控件名称。
        String u = req.getParameter("username");
        String p = req.getParameter("passwd");

        // ---------------------
        // 调用 UserBeanCl 的方法
        UserBeanCl userBeanCl = new UserBeanCl();
        try {
            if (userBeanCl.checkUser(u, p)) {
                System.out.println("[LoginCl] UserBeanCl checked is ok.");
                // ---------------------
                // ServletContext 操作 times
                ServletContext sc = this.getServletContext();
                String sCount = sc.getAttribute("times").toString();
                System.out.println("[LoginCl] get from sc times=" + sCount);
                sc.setAttribute("times", String.valueOf(Integer.parseInt(sCount) + 1));

                // ---------------------
                // 进行 session 操作，写入一对 kv 值。
                HttpSession session = req.getSession(true);
                // 分配唯一 session ID 值，与其他页面共享。
                System.out.println("[LoginCl] session id=" + session.getId());
                // 默认失效时间为 30 分钟，下面可以指定为 10 秒。（注意，10 秒内无操作 session 才失效。）
                // 如果为 0 值，session 都将被情况，包括其 session 也是 null。
                session.setMaxInactiveInterval(10);
                // session 写入一个key-value 值。并且，session 保存用户名，做登录验证判断。
                session.setAttribute("uname", u);
                session.setAttribute("passwd", p);

                // ---------------------
                // 操作 cookie 保存用户配置
                // 1. 先在服务器端创建一个 cookie
                Cookie cookie = new Cookie("color", "8CADFF");
                // 2. 设置该 cookie 存在的时间，单位秒。注意，如果不设置，那么该 cookie 将不会被保存。
                cookie.setMaxAge(30);
                // 3. 将该 cookie 写回到客户端。
                resp.addCookie(cookie);
                System.out.println("[LoginCl] create a cookie: color=" + cookie.getValue());

                // ---------------------
                // 复选框是否选择
                String keep = req.getParameter("keep");
                if (keep != null) {
                    // Cookie 操作
                    // 1. 创建两个 Cookie 值
                    Cookie cookieName = new Cookie("myname", u);
                    Cookie cookiePasswd = new Cookie("mypasswd", p);
                    // 2. 设置 Cookie 生存周期，以下是两周时间
                    cookieName.setMaxAge(2 * 7 * 24 * 3600);
                    // 3. 回写到客户端
                    resp.addCookie(cookieName);
                    resp.addCookie(cookiePasswd);
                }

                // 用户和密码都验证通过的情况，跳转页面 welcome。
                resp.sendRedirect("main");
            } else {
                // 用户和密码检查错误的情况，跳转 login 页面。
                System.out.println("[LoginCl] password checked is false. return login page.");
                resp.sendRedirect("login");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
