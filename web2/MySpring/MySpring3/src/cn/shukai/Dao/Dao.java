package cn.shukai.Dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class Dao extends JdbcDaoSupport implements D{

    @Override
    public void add(String name, Integer money) {
        String sql="update account set money=money+? where name=?";
        super.getJdbcTemplate().update(sql,money,name);
    }

    @Override
    public void decrease(String name, Integer money) {
        String sql="update account set money=money-? where name=?";
        super.getJdbcTemplate().update(sql,money,name);
    }
}
