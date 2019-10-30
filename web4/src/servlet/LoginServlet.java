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

@WebServlet(name = "LoginServlet",urlPatterns="/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserService userService = new UserService();
        Map map2 = request.getParameterMap();
        try {
            User form2 = CommonUtil.toBean(map2, User.class);
            try {
                    User u = userService.login(form2);
                    request.getSession().setAttribute("user", u);
                    response.sendRedirect(request.getContextPath() + "/success.jsp");
            }catch (SQLException e) {
                throw new RuntimeException();
            }catch (ClassException e) {
                 request.setAttribute("msg", e.getMessage());
                 request.setAttribute("user", form2);
                 request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }catch (IllegalAccessException e) {
            throw new RuntimeException();
        }catch (InstantiationException e) {
            throw new RuntimeException();
        }
    }
}