package demo1;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MyServlet")
public class MyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext app = this.getServletContext();
        Integer count =(Integer)app.getAttribute("count");
        if(count==null){
            app.setAttribute("count",1);
        }
        else{
            app.setAttribute("count",count+1);
        }
        response.getWriter().print(count);
    }
}
