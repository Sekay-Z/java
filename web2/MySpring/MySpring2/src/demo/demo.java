package demo;


import User.User;
import cn.shukai.jdbc.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo {
    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("spring-config.xml");
        UserDaoImpl ud= (UserDaoImpl) app.getBean("userDao");
        User u=new User();
        ud.delete(3);
    }
}
