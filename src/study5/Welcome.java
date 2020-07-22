package study5;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * 1. session 操作
 * 2. 分页操作
 * 3. cookie 操作
 */

public class Welcome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

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
                    resp.sendRedirect("login?username=" + valueName + "&passwd=" + valuePasswd);
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

        // 分页操作
        // 先设定两个值：
        // - 每页的记录数为3条；
        // - 翻页的 pageNow 值；
        int pageSize = 3;
        int pageNow = 0;

        try {
            String sPageNow = req.getParameter("pageNow");
            if (sPageNow != null) {
                pageNow = Integer.parseInt(sPageNow);
            }

            // 调用 UserBeanCl 的 getResultByPage 方法来分页处理。
            UserBeanCl userBeanCl = new UserBeanCl();
            ArrayList al = null;

            al = userBeanCl.getResultByPage(pageNow, pageSize);

            // 显示记录，以 table 表格的方式。
            pw.println("<table border=1>");
            pw.println("<tr bgcolor=pink><th>ID</th><th>NAME</th><th>PASSWD</th><th>EMAIL</th><th>GRADE</th><th>SEX</th><th>ACTION</th></tr>");
            String[] myColor = {"silver", "orange"};
            for (int k = 0; k < al.size(); k++) {
                UserBean ub = (UserBean) al.get(k);
                pw.println("<tr bgcolor=" + myColor[k % 2] + ">");
                pw.println("<td>" + ub.getUserId() + "</td>");
                pw.println("<td>" + ub.getUsername() + "</td>");
                pw.println("<td>" + ub.getPasswd() + "</td>");
                pw.println("<td>" + ub.getEmail() + "</td>");
                pw.println("<td>" + ub.getGrade() + "</td>");
                pw.println("<td>" + ub.getSex() + "</td>");
                pw.println("<td>[<a href=#>修改</a>][<a href=del_user?userid=" + ub.getUserId() + " onclick=\"return window.confirm('确定要删除此用户吗？')\">删除</a>]</td>");
                pw.println("</tr>");
            }
            pw.println("</table>");

            // 分页操作
            if (pageNow != 1)
                pw.println("<a href=welcome?pageNow=" + (pageNow - 1) + ">上一页</a>");
            for (int i = 1; i <= userBeanCl.getPageCount(); i++) {
                pw.println("<a href=welcome?pageNow=" + i + ">" + i + "</a>");
            }
            if (pageNow != userBeanCl.getPageCount())
                pw.println("<a href=welcome?pageNow=" + (pageNow + 1) + ">下一页</a>");

            pw.println("<form action=welcome>");
            pw.println("<input type=text name=pageNow>");
            pw.println("<input type=submit value=go>");
            pw.println("</form>");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        pw.println("<br><b>网站被访问了 " + String.valueOf(this.getServletContext().getAttribute("times")) + " 次</b>");
        pw.println("<br><b>您的 IP 地址：" + req.getRemoteAddr() + "</b>");

        pw.println("<body><center>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
