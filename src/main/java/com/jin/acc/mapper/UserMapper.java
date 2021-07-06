package com.jin.acc.mapper;

import com.jin.acc.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> getAllUser();
    public void addUser(User user);
    public User getUserByName(String username);
    public void deleUserById(int id);
    public User getUserById(int id);
    public void modifyUserById(User user);
    public int getmaxUserId();
    public int getUserCount();

    //public int getIdByname(String username);




}
