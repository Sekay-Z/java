package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter")
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        HttpServletRequest request=(HttpServletRequest)req;
        String name=(String)request.getSession().getAttribute("admin");
        if(name!=null){
            chain.doFilter(req,resp);
        }else{
            request.setAttribute("msg","你不是管理员请滚开");
            request.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
