package com.tong.dao;

import com.tong.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

@Resource
@Mapper
public interface UserMapper {

    User checkUser(String name,String password);
}
