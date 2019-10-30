package service;

import dao.UserDao;
import domain.User;

public class UserService {
    UserDao userdao=new UserDao();
    public User find(){
       return userdao.find();
    }
}
