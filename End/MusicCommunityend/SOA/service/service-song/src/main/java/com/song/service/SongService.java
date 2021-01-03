package com.song.service;

import com.song.model.Song;

public interface SongService {
    Song selectSongById(Long id);

    Object insertSong(Song song);

    void delSong(Long id);
}
