package study5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 显示中文字体问题
        resp.setContentType("text/html;charset=utf-8");

        // Get 方法，响应的 html 内容
        PrintWriter pw = resp.getWriter();
        pw.println("<html>");
        pw.println("<body>");
        pw.println("<h1>登录界面</h1>");

        String info = req.getParameter("info");
        if  (info != null){
            pw.println("<h2>登录验证错误。</h2></br>");
        }

        pw.println("<form action=loginCl method=post>");
        pw.println("用户名：<input type=text name=username /><br>");
        pw.println("密码：<input type=password name=passwd /><br>");
        pw.println("<input type=checkbox name=keep value=2>两周内不再重新登录<br>");
        pw.println("<input type=hidden name=sex value=0 /><br>");
        pw.println("<input type=submit value=Submit />");
        pw.println("</form>");

        pw.println("</body>");
        pw.println("</html>");

    }
}
