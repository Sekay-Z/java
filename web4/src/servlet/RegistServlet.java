package servlet;

import CommonUtil.CommonUtil;
import domain.User;
import service.ClassException;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "RegistServlet",urlPatterns = "/RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserService userService = new UserService();
        Map map = request.getParameterMap();
        try {
            User form = CommonUtil.toBean(map, User.class);
            try {
                userService.regist(form);
                response.getWriter().print("<h1>注册成功</h1><a href='" + request.getContextPath() + "/success.jsp'>点击此处完成登录</a>");
            } catch (ClassException e) {
                String msg = e.getMessage();
                request.setAttribute("msg", msg);
                request.setAttribute("user",form);
                request.getRequestDispatcher("/regist.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
