package study5;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Main extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ---------------------
        // cookie 操作
        Cookie[] cookies = req.getCookies();
        int j;
        if (cookies != null) {
            for (j = 0; j < cookies.length; j++) {
                Cookie temp = cookies[j];
                if (temp.getName().equals("color")) {
                    String val = temp.getValue();
                    System.out.println("[Welcome] cookie: key=color, value=" + val);
                    break;
                }
            }
            if (cookies.length == j) {
                System.out.println("[Welcome] cookie is timeout.");
            }
        } else {
            System.out.println("[Welcome] cookie is not have. or timeout.");
        }


        // session 操作
        // - 根据 key 获取 value 的值，并进行判断是否登录成功。
        // - 分配唯一 session ID 值，与其他页面共享。
        System.out.println("[Welcome] session id=" + req.getSession(true).getId());
        HttpSession session = req.getSession(true);

        // 1. session 判断 uname 的值
        String myName = (String) session.getAttribute("uname");
        if (myName == null) {
            // session 此用户不存在的情况下，再看看有没有 cookie 的信息。
            Cookie[] myCookies = req.getCookies();
            String valueName = null;
            String valuePasswd = null;
            if (cookies != null) {
                for (int i = 0; i < myCookies.length; i++) {
                    Cookie cookie1 = myCookies[i];
                    if (cookie1.getName().equals("myname")) {
                        valueName = cookie1.getValue();
                    } else if (cookie1.getName().equals("mypasswd")) {
                        valuePasswd = cookie1.getValue();
                    }
                }
                System.out.println("[Welcome] cookie test: username=" + valueName + ", passwd=" + valuePasswd);
                if (!valueName.equals("") && !valuePasswd.equals("")) {
                    resp.sendRedirect("login?username="+valueName+"&passwd="+valuePasswd);
                    return;
                }
            }
            resp.sendRedirect("login?info=error");
        }

        // 显示中文字体问题
        resp.setContentType("text/html;charset=utf-8");

        // 返回浏览器并显示
        PrintWriter pw = resp.getWriter();
        pw.println("<body bgcolor=#8CADFF><center>");
        pw.println("<img src=images/1.png /><br>");
        pw.println("Welcome, " + myName);

        pw.println("<p>");
        pw.println("[首页]|");
        pw.println("[<a href=welcome>用户管理</a>]|");
        pw.println("[退出]|");
        pw.println("<p>");

        pw.println("<br><b>网站被访问了 " + String.valueOf(this.getServletContext().getAttribute("times")) + " 次</b>");
        pw.println("<br><b>您的 IP 地址：" + req.getRemoteAddr() + "</b>");

        pw.println("<body><center>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
