package com.comment.service;

import com.comment.model.Songcomment;

public interface SongcommentService {

    Songcomment selectSongcommentById(Long id);

    Object insertUser(Songcomment songcomment);

    void deSongComment(Long id);

    Object updateSongcomment(Songcomment songcomment);
}
