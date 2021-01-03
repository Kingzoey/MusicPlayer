package com.song.mapper;

import com.song.model.Song;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SongMapper {
    int deleteByPrimaryKey(Long sid);

    int insert(Song record);

    int insertSelective(Song record);

    Song selectByPrimaryKey(Long sid);

    int updateByPrimaryKeySelective(Song record);

    int updateByPrimaryKey(Song record);
}