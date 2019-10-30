package JdbcUtils3;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils3 {
        private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
        private static Properties prop;
        private static Connection con;
        private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
        static {
            InputStream in=JdbcUtils3.class.getClassLoader().getResourceAsStream("JdbcUtils3.properties");
            prop=new Properties();
            try {
                prop.load(in);
            } catch (IOException e) {
                throw new RuntimeException();
            }
            try {
                dataSource.setDriverClass(prop.getProperty("driverClass"));
            } catch (PropertyVetoException e) {
                throw new RuntimeException();
            }
            dataSource.setJdbcUrl(prop.getProperty("jdbcUrl"));
            dataSource.setUser(prop.getProperty("user"));
            dataSource.setPassword(prop.getProperty("password"));
            dataSource.setAcquireIncrement(Integer.parseInt(prop.getProperty("acquireIncrement")));
            dataSource.setInitialPoolSize(Integer.parseInt(prop.getProperty("initialPoolSize")));
            dataSource.setMinPoolSize(Integer.parseInt(prop.getProperty("minPoolSize")));
            dataSource.setMaxPoolSize(Integer.parseInt(prop.getProperty("maxPoolSize")));
        }
        public static Connection getConnection() throws SQLException {
            if(con!=null){
                return con;
            }
            return dataSource.getConnection();
        }
        public static DataSource getDataSource() {
            return dataSource;
        }
        public static void beginTransaction() throws SQLException {
            Connection con=tl.get();
            if(con!=null){
                throw new RuntimeException("事务已经开始，请勿重复开启");
            }
            con=JdbcUtils3.getConnection();
            con.setAutoCommit(false);
            tl.set(con);
        }
        public static void commitTransaction() throws SQLException {
            Connection con=tl.get();
            if(con==null){
                throw new RuntimeException("还没开始事务，不能提交");
            }
            con.commit();
            con.close();
            tl.remove();
        }
        public static void rollbackTransaction() throws SQLException {
            Connection con=tl.get();
            if(con==null) {
                throw new RuntimeException("还没开始事务，不能回滚");
            }
            con.rollback();
            con.close();
            tl.remove();
        }
        public static void releaseConnection(Connection connection) throws SQLException {
            if(con==null){
                connection.close();;
            }
            if(con!=connection){
                connection.close();
            }
        }
}