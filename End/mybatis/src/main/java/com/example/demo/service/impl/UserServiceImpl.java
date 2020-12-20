package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByID(Integer uId) {
        return userMapper.selectByPrimaryKey(uId);
    }
    @Override
    public void deUser(Integer id){
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User insertUser(User user) {
        userMapper.insert(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
        return  user;
    }

}
