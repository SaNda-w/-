package com.jin.acc.service.impl;

import com.github.pagehelper.PageHelper;
import com.jin.acc.entity.User;
import com.jin.acc.mapper.UserMapper;
import com.jin.acc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public void deleUserById(int id) {
        userMapper.deleUserById(id);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void modifyUserById(User user) {
        userMapper.modifyUserById(user);
    }

    @Override
    public int getmaxUserId() {
        return userMapper.getmaxUserId();
    }

    public boolean verify(String loginname,String loginpsw){
        User user=userMapper.getUserByName(loginname);
        if(user==null)return false;
        else if(user.getPassword().equals(loginpsw)&&user.getUsername().equals(loginname))return true;
        else return false;
    }

    @Override
    public List<User> getPageUser(int currentPage,int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        return userMapper.getAllUser();
    }

    @Override
    public int getUserCount() {
        return userMapper.getUserCount();
    }




}
