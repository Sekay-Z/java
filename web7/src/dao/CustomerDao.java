package dao;

import JdbcUtils3.JdbcUtils3;
import JdbcUtils3.TxQueryRunner;
import domain.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    QueryRunner qr=new TxQueryRunner(JdbcUtils3.getDataSource());
    public void add(Customer cstm) throws SQLException {
        String sql="insert into customer values(?,?,?,?)";
        Object[] params={cstm.getCname(),cstm.getGender(),cstm.getCellphone(),cstm.getEmail()};
        qr.update(sql,params);
    }
    public List<Customer> findALL() throws SQLException {
        String sql="select * from customer";
        return qr.query(sql,new BeanListHandler<Customer>(Customer.class));
    }
    public Customer findByCname(String cname) throws SQLException {
        String sql="select * from customer where cname=?";
        return qr.query(sql,new BeanHandler<Customer>(Customer.class),cname);
    }
    public void delete(String cname) throws SQLException {
        String sql="delete from customer where cname=?";
        qr.update(sql,cname);
    }
    public void edit(Customer cstm) throws SQLException {
        String sql="update customer set gender=?,cellphone=?,email=? where cname=?";
        Object[] params={cstm.getGender(),cstm.getCellphone(),cstm.getEmail(),cstm.getCname()};
        qr.update(sql,params);
    }
    public List<Customer> query(Customer cstm) throws SQLException {
        StringBuilder s=new StringBuilder("select * from customer where 1=1");
        List<String> params=new ArrayList<String>();
        if(cstm.getCname()!=null && !cstm.getCname().trim().isEmpty()){
            String sql1=" and cname=?";
            s.append(sql1);
            params.add(cstm.getCname());
        }
        if(cstm.getGender()!=null && !cstm.getGender().trim().isEmpty()){
            String sql2=" and gender=?";
            s.append(sql2);
            params.add(cstm.getGender());
        }
        if(cstm.getCellphone()!=null && !cstm.getCellphone().trim().isEmpty()){
            String sql3=" and cellphone=?";
            s.append(sql3);
            params.add(cstm.getCellphone());
        }
        if(cstm.getEmail()!=null && !cstm.getEmail().trim().isEmpty()){
            String sql4=" and email=?";
            s.append(sql4);
            params.add(cstm.getEmail());
        }
        return qr.query(s.toString(),new BeanListHandler<Customer>(Customer.class),params.toArray());
    }
}
