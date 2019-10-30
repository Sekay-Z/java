package text;

import CommonUtil.CommonUtil;
import dao.DaoFactory;
import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Text {
    public static void main(String[] args) throws IOException, SQLException {
       Map<String,String> m=new HashMap<>();
       m.put("username","李洋");
       m.put("password","liyang");
        try {
            User u=CommonUtil.toBean(m,User.class);
            System.out.println(u);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
