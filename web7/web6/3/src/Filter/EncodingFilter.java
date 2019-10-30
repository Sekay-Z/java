package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "Filter",urlPatterns = "/*")
public class EncodingFilter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpServletRequest request=(HttpServletRequest)req;
        if(request.getMethod().equals("GET")){
            EncodingRequest en=new EncodingRequest(request);
            chain.doFilter(en,resp);
        }else if(request.getMethod().equals("POST")){
            chain.doFilter(req,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
