package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userservice;

    @RequestMapping(value ="/select")
    public @ResponseBody Object user(Integer uId){
       User user= userservice.selectUserByID(uId);
        return user;
    }

    @RequestMapping(value ="/insert/{uId}/{nickname}/{password}")
    public Object insertUser(@PathVariable Integer uId,@PathVariable String password,@PathVariable String nickname){
        User user = new User();
        user.setuId(uId);
        user.setNickname(nickname);
        user.setPassword(password);
        return userservice.insertUser(user);

    }
    @RequestMapping("/del/{id}")
    public void  Del(@PathVariable Integer id){
        userservice.deUser(id);
    }

    @RequestMapping("/update/{uId}/{password}/{nickname}")
    public Object updateUser(@PathVariable Integer uId,@PathVariable String password,@PathVariable String nickname){
        User user = new User();
        user.setuId(uId);
        user.setNickname(nickname);
        user.setPassword(password);
        return userservice.updateUser(user);
    }

}
//@Controller
//public class UserController {
//    @RequestMapping(value="/test/say")
//    public @ResponseBody
//    String say(){
//        return "杰哥nb";
//    }
//
//}