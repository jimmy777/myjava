package study5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelUserCl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 接受 Userid
        String id = req.getParameter("userid");

        // 调用 UserBeanCl 删除用户方法
        UserBeanCl ubc = new UserBeanCl();
        if (ubc.delUser(id)) {
            resp.sendRedirect("ok");
        } else {
            resp.sendRedirect("err");
        }
    }
}
