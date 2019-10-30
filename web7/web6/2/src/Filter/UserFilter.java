package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "UserFilter")
public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        String name=(String)request.getSession().getAttribute("admin");
        if(name!=null){
            chain.doFilter(req, resp);
            return;
        }
        String name2=(String) request.getSession().getAttribute("user");
        if(name2!=null){
            chain.doFilter(req,resp);
        }else{
            request.setAttribute("msg","不是会员请滚开");
            request.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
