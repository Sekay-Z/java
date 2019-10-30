package dao;

import JdbcUtils3.JdbcUtils3;
import JdbcUtils3.TxQueryRunner;
import domain.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDao {
    private QueryRunner qr=new TxQueryRunner(JdbcUtils3.getDataSource());
    public List<Book> findAll(){
        String sql="select * from book";
        try {
            return qr.query(sql,new BeanListHandler<>(Book.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Book> findByCategory(int category){
        String sql="select * from book where category=?";
        try {
            return qr.query(sql,new BeanListHandler<>(Book.class),category);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
