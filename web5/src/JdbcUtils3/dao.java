package JdbcUtils3;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class dao {
    public void update(String name,int money) throws SQLException {
        QueryRunner qr=new TxQueryRunner(JdbcUtils3.getDataSource());
        String sql="update account set money=money+? where name=?";
        Object[] params={money,name};
        qr.update(sql,params);
    }
}
