package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;


public interface UserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    int insertSelective(User record);//

    User selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(User record);//

    int updateByPrimaryKey(User record);
}