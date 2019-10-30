package service;

import Msg.Msg;
import dao.CustomerDao;
import domain.Customer;

import java.sql.SQLException;
import java.util.List;

public class Service {
    private CustomerDao customerDao=new CustomerDao();
    public void add(Customer cstm) throws SQLException {
        customerDao.add(cstm);
    }
    public List<Customer> findAll() throws SQLException {
        return customerDao.findALL();
    }
    public Customer findByCname(String cname) throws SQLException, Error, Msg {

        Customer c=customerDao.findByCname(cname);
        if(c==null) {
            return null;
        }
        else{
            throw new Msg("用户已注册");
        }
    }
    public void delete(String cname) throws SQLException {
        customerDao.delete(cname);
    }
    public void edit(Customer cstm) throws SQLException {
        customerDao.edit(cstm);
    }
    public List<Customer> query(Customer cstm) throws SQLException {
        return customerDao.query(cstm);
    }
}
