package servlet;

import CommonUtils.BaseServlet;
import CommonUtils.CommonUtils;

import java.io.UnsupportedEncodingException;
import java.lang.Error;

import Msg.Msg;
import domain.Customer;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet",urlPatterns = "/CustomerServlet")
public class CustomerServlet extends BaseServlet {
    private Service service=new Service();
    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, InstantiationException, IllegalAccessException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Customer cstm = CommonUtils.toBean(request.getParameterMap(), Customer.class);
        Map<String,String> error=new HashMap<String,String>();
        if(cstm.getCname()==null ||cstm.getCname().trim().isEmpty()){
            error.put("cname","用户名不能为空");
        }else if(cstm.getCname().length()<3 || cstm.getCname().length()>15){
            error.put("cname","用户名长度必须在3到15之间");
        }
        if(cstm.getCellphone()==null || cstm.getCellphone().trim().isEmpty()){
            error.put("cellphone","电话不能为空");
        }else if(cstm.getCellphone().length()<3 || cstm.getCellphone().length()>15){
            error.put("cellphone","电话长度必须在3到15之间");
        }
        if(cstm.getEmail()==null || cstm.getEmail().trim().isEmpty()){
            error.put("email","邮件不能为空");
        }else if(cstm.getEmail().length()<3 || cstm.getEmail().length()>15){
            error.put("email","邮件用户名长度必须在3到15之间");
        }
        if(error.size()>0){
            request.setAttribute("error",error);
            request.setAttribute("cstm",cstm);
            return "/add.jsp";
        }
        try {
            service.findByCname(cstm.getCname());
            service.add(cstm);
            request.setAttribute("msg", "恭喜，添加用户成功");
        } catch (Msg msg) {
            request.setAttribute("msg",msg.getMessage());
            request.getRequestDispatcher("/msg.jsp").forward(request,response);
        }
        return "/msg.jsp";
    }
    public String findAll(HttpServletRequest request,HttpServletResponse response) throws SQLException {
        List<Customer> customerList=service.findAll();
        request.setAttribute("customerList",customerList);
        return "f:/list.jsp";
    }
    public String delete(HttpServletRequest request,HttpServletResponse response) throws SQLException {
        String cname=request.getParameter("cname");
        service.delete(cname);
        return findAll(request,response);
    }
    public String edit(HttpServletRequest request,HttpServletResponse response) throws InstantiationException, IllegalAccessException, SQLException {
        Customer cstm=CommonUtils.toBean(request.getParameterMap(),Customer.class);
        service.edit(cstm);
        return findAll(request,response);
    }
    public String query(HttpServletRequest request,HttpServletResponse response) throws InstantiationException, IllegalAccessException, SQLException, UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Customer cstm=CommonUtils.toBean(request.getParameterMap(),Customer.class);
        request.setAttribute("customerList",service.query(cstm));
        return "/list.jsp";
    }
}
