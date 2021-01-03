package com.comment.controller;

import com.comment.model.Songcomment;
import com.comment.service.SongcommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController {
    @Autowired
    private SongcommentService songcommentService;

    @RequestMapping(value = "/comment/select/{id}")
    public @ResponseBody Object songcomments(@PathVariable Long id){
        Songcomment songcomment = songcommentService.selectSongcommentById(id);
        return songcomment;
    }
    //全插入
    @RequestMapping(value = "/comment/insert/{scid}/{usid}/{sid}/{content}")
    public @ResponseBody Object insertSongcomment(@PathVariable Long scid,@PathVariable Integer usid,@PathVariable Long sid,@PathVariable String content){

        Songcomment songcomment = new Songcomment();
        songcomment.setContent(content);
        songcomment.setScid(scid);
        songcomment.setUsid(usid);
        songcomment.setScid(scid);
        return songcommentService.insertUser(songcomment);
    }

    @RequestMapping("comment/del/{id}")
    public void DelSongComment(@PathVariable Long id){
       songcommentService.deSongComment(id);
    }

    @RequestMapping(value = "/comment/update/{scid}/{usid}/{sid}/{content}")
    public @ResponseBody Object updateSongcomment(@PathVariable Long scid,@PathVariable Integer usid,@PathVariable Long sid,@PathVariable String content){

        Songcomment songcomment = new Songcomment();
        songcomment.setContent(content);
        songcomment.setScid(scid);
        songcomment.setUsid(usid);
        //songcomment.setSid(sid);
        return songcommentService.updateSongcomment(songcomment);
    }


}



//    @RequestMapping("/update/{uId}/{password}/{nickname}")
//    public Object updateUser(@PathVariable Integer uId,@PathVariable String password,@PathVariable String nickname){
//        User user = new User();
//        user.setuId(uId);
//        user.setNickname(nickname);
//        user.setPassword(password);
//        return userservice.updateUser(user);
//    }
