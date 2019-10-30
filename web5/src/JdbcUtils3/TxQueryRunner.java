package JdbcUtils3;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TxQueryRunner extends QueryRunner{
    public TxQueryRunner(DataSource ds) {
        super(ds);
    }

    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        Connection con=JdbcUtils3.getConnection();
        int[] rezult = super.batch(sql,params);
        JdbcUtils3.releaseConnection(con);
        return rezult;
    }

    @Override
    public <T> T query(String sql, Object param, ResultSetHandler<T> rsh) throws SQLException {
        Connection con=JdbcUtils3.getConnection();
        T rezult = super.query(sql,param,rsh);
        JdbcUtils3.releaseConnection(con);
        return rezult;
    }

    @Override
    public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh) throws SQLException {
        Connection con=JdbcUtils3.getConnection();
        T rezult = super.query(sql,params,rsh);
        JdbcUtils3.releaseConnection(con);
        return rezult;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection con=JdbcUtils3.getConnection();
        T rezult = super.query(sql,rsh,params);
        JdbcUtils3.releaseConnection(con);
        return rezult;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection con=JdbcUtils3.getConnection();
        T rezult = super.query(sql,rsh);
        JdbcUtils3.releaseConnection(con);
        return rezult;
    }

    @Override
    public int update(String sql) throws SQLException {
        Connection con=JdbcUtils3.getConnection();
        int rezult = super.update(sql);
        JdbcUtils3.releaseConnection(con);
        return rezult;
    }

    @Override
    public int update(String sql, Object param) throws SQLException {
        Connection con=JdbcUtils3.getConnection();
        int rezult = super.update(sql,param);
        JdbcUtils3.releaseConnection(con);
        return rezult;
    }

    @Override
    public int update(String sql, Object... params) throws SQLException {
        Connection con=JdbcUtils3.getConnection();
        int rezult = super.update(sql,params);
        JdbcUtils3.releaseConnection(con);
        return rezult;
    }

    @Override
    public <T> T insert(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection con=JdbcUtils3.getConnection();
        T rezult = super.insert(sql,rsh);
        JdbcUtils3.releaseConnection(con);
        return rezult;
    }

    @Override
    public <T> T insert(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection con=JdbcUtils3.getConnection();
        T rezult = super.insert(sql,rsh,params);
        JdbcUtils3.releaseConnection(con);
        return rezult;
    }

    @Override
    public <T> T insertBatch(String sql, ResultSetHandler<T> rsh, Object[][] params) throws SQLException {
        Connection con=JdbcUtils3.getConnection();
        T rezult = super.insertBatch(sql,rsh,params);
        JdbcUtils3.releaseConnection(con);
        return rezult;
    }
}
