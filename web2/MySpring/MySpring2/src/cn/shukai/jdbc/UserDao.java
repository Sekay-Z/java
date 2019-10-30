package cn.shukai.jdbc;

import User.User;

import java.util.List;

public interface UserDao {
    public void add(User u);
    public void delete(Integer id);
    public User find(Integer id);
    public void update(User u);
    public List<User> getAll();
}
