package Fliter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Map;

@WebFilter(filterName = "Filter",urlPatterns = "/show.jsp")
public class Filter implements javax.servlet.Filter {
    private FilterConfig con;
    public void destroy() {}
    public void init(FilterConfig config) throws ServletException {
        this.con=config;
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        ServletContext app=con.getServletContext();
        Map<String,Integer> map=(Map<String,Integer>)app.getAttribute("map");
        String ip=req.getRemoteAddr();
        if(map.containsKey(ip)){
            int i=map.get(ip);
            map.put(ip,i+1);
        }else{
            map.put(ip,1);
        }
        app.setAttribute("map",map);
        chain.doFilter(req, resp);
    }
}
