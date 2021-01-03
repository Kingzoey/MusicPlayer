package com.song.controller;


import com.song.model.Song;
import com.song.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SongController {
    @Autowired
    private SongService songService;
    //根据id搜索歌名
    @RequestMapping(value = "/song/select/{id}")
    public @ResponseBody Object songs (@PathVariable Long id){
        Song song = songService.selectSongById(id);
        return song;
    }
    //全插入
    @RequestMapping(value = "/song/insert/{sid}/{usid}/{title}")
    public @ResponseBody Object insertSong(@PathVariable Long sid,@PathVariable Integer usid,@PathVariable String title){

        Song song = new Song();
        song.setSid(sid);
        song.setUsid(usid);
        song.setTitle(title);
        return songService.insertSong(song);
    }

    @RequestMapping("song/del/{id}")
    public void DelSong(@PathVariable Long id){
        songService.delSong(id);
    }
}