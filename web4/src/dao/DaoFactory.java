package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
    private static Properties prop;
    static{
        try {
            InputStream in=DaoFactory.class.getResourceAsStream("UserDaoImpl.properties");
            prop=new Properties();
            prop.load(in);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    public static UserDao getUserDao() {
        try {
            String p = prop.getProperty("userdaoimpl");
            Class clazz = Class.forName(p);
            return (UserDao)clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
