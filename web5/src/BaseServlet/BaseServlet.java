package BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseServlet",urlPatterns = "/BaseServlet")
public class BaseServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodName = request.getParameter("method");
        if(methodName==null||methodName.trim().isEmpty()){
            throw new RuntimeException("您还没有传递method参数，无法确定请求方法");
        }
        Class c = this.getClass();
        Method m = null;
        try {
            m = c.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("不好意思，您的请求方法"+methodName+"不存在");
        }
        try {
            String s= (String) m.invoke(this,request,response);
            if(s==null||s.trim().isEmpty()){
                return;
            }
            if(s.contains(":")){
                int index=s.indexOf(":");
                String ss=s.substring(0,index);
                String sss=s.substring(index+1);
                if(ss.equalsIgnoreCase("f")){
                    request.getRequestDispatcher(sss).forward(request,response);
                }else if(ss.equalsIgnoreCase("r")){
                    response.sendRedirect(request.getContextPath()+sss);
                }else{
                    throw new RuntimeException("抱歉，您指定的操作"+ss+"当前版本还不支持");
                }
            }else{
                request.getRequestDispatcher(s).forward(request,response);
            }
        } catch (Exception e) {
            throw new RuntimeException("您调用的方法"+methodName+"内部出错！");
        }
    }
}
