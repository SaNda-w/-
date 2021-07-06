package com.jin.acc.service;

import com.jin.acc.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public void addUser(User user);
    public User getUserByName(String username);
    public void deleUserById(int id);
    public User getUserById(int id);
    public void modifyUserById(User user);
    public int getmaxUserId();
    boolean verify(String loginname, String loginpsw);
    public List<User> getPageUser(int currentPage,int pageSize);
    public int getUserCount();
    //public int getIdByname(String username);

}
