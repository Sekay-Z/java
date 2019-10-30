package dao;

import domain.User;

import java.io.IOException;
import java.sql.SQLException;

public interface UserDao {
    public abstract User findByUsername(String username) throws SQLException;
    public abstract  void add(User user);
}
