package com.tong.service.impl;

import com.tong.dao.UserMapper;
import com.tong.pojo.User;
import com.tong.service.UserService;
import com.tong.utils.MD5Utils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper){
        this.userMapper =userMapper;
    }


    @Override
    public User checkUser (String username,String password){
        User user = userMapper.checkUser(username, MD5Utils.code(password));
        System.out.println(user);
        return user;
    }
}
