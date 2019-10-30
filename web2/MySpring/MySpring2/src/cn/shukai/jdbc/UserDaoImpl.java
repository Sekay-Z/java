package cn.shukai.jdbc;

import User.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao{
  /*  JdbcTemplate jt=new JdbcTemplate();
*/
   /* public UserDaoImpl(JdbcTemplate jt) {
        this.jt = jt;
    }*/

    public UserDaoImpl() {
    }

    @Override
    public void add(User u) {
        String sql="insert into u values(?,? )";
        super.getJdbcTemplate().update(sql,u.getId(),u.getName());
    }

    @Override
    public void delete(Integer id) {
        String sql="delete from u where id=?";
        super.getJdbcTemplate().update(sql,id);
    }

    @Override
    public User find(Integer id) {
        String sql="select * from u where id=?";
        return super.getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User uu=new User();
                uu.setId(resultSet.getInt(i));
                uu.setName(resultSet.getString(i));
                return uu;
            }
        },id);
    }

    @Override
    public void update(User u) {
        String sql="update u set name=? where id=?";
        super.getJdbcTemplate().update(sql,u.getName(),u.getId());
    }

    @Override
    public List<User> getAll() {
        String sql="select * from u";
        return super.getJdbcTemplate().query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User uu=new User();
                uu.setId(resultSet.getInt(i));
                uu.setName(resultSet.getString(i));
                return uu;
            }
        });
    }

  /*  public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    public JdbcTemplate getJt() {
        return jt;
    }*/
}
