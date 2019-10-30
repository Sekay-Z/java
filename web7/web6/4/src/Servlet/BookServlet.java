package Servlet;

import BaseServlet.BaseServlet;
import dao.BookDao;
import domain.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet",urlPatterns = "/BookServlet")
public class BookServlet extends BaseServlet {
    private BookDao bd=new BookDao();
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> lb=bd.findAll();
        request.setAttribute("lb",lb);
        return "/show.jsp";
    }
    public String findByCategory(HttpServletRequest request, HttpServletResponse response){
        int c=Integer.parseInt(request.getParameter("category"));
        List<Book> lb=bd.findByCategory(c);
        request.setAttribute("lb",lb);
        return "/show.jsp";
    }
}
