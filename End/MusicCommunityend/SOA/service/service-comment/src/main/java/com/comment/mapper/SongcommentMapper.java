package com.comment.mapper;

import com.comment.model.Songcomment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SongcommentMapper {
    int deleteByPrimaryKey(Long scid);

    int insert(Songcomment record);

    int insertSelective(Songcomment record);//部分插

    Songcomment selectByPrimaryKey(Long scid);//

    int updateByPrimaryKeySelective(Songcomment record);//部分改

    int updateByPrimaryKey(Songcomment record);
}