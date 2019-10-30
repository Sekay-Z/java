package service;

import dao.DaoFactory;
import dao.UserDao;
import domain.User;

import java.sql.SQLException;

public class UserService {
    private UserDao userdao = DaoFactory.getUserDao();
    public void regist(User form) throws ClassException, SQLException {
        User newuser=userdao.findByUsername(form.getUsername());
        if(newuser==null){
            userdao.add(form);
        }else{
            throw new ClassException("用户名"+newuser.getUsername()+"已被注册");
        }
    }
    public User login(User form2) throws SQLException, ClassException {
        User olduser=userdao.findByUsername(form2.getUsername());
        if(olduser==null){
            throw new ClassException("用户名不存在");
        }
        if(!olduser.getPassword().equals(form2.getPassword())){
            throw new ClassException("用户密码错误!");
        }
        return olduser;
    }
}
