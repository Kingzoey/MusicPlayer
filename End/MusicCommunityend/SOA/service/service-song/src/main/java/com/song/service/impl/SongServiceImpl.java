package com.song.service.impl;

import com.song.mapper.SongMapper;
import com.song.model.Song;
import com.song.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongMapper songMapper;

    @Override
    public Song selectSongById(Long id){
        return songMapper.selectByPrimaryKey(id);
    }

    @Override
    public Object insertSong(Song song){return songMapper.insert(song);}

    @Override
    public void delSong(Long id) {
        songMapper.deleteByPrimaryKey(id);
    }

}
