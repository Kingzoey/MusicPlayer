package com.comment.service.impl;

import com.comment.mapper.SongcommentMapper;
import com.comment.model.Songcomment;
import com.comment.service.SongcommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongcommentServiceImpl implements SongcommentService {
    @Autowired
    private SongcommentMapper songcommentMapper;

    @Override
    public Songcomment selectSongcommentById(Long id){
        return songcommentMapper.selectByPrimaryKey(id);

    }

    @Override
    public Object insertUser(Songcomment songcomment) {
        return songcommentMapper.insert(songcomment);
    }

    @Override
    public void deSongComment(Long id) {
         songcommentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Object updateSongcomment(Songcomment songcomment) {
        return songcommentMapper.updateByPrimaryKey(songcomment);
    }
}
