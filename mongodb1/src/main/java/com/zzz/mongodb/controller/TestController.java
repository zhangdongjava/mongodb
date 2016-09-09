package com.zzz.mongodb.controller;

import com.zzz.mongodb.entry.User;
import com.zzz.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by dell_2 on 2016/8/30.
 */
@Controller
public class TestController {

    @Autowired
    private UserService userService;
    @RequestMapping("test")
    @ResponseBody
    public Object test(){

        return "666";
    }

    @RequestMapping("addUser")
    @ResponseBody
    public Object addUser(User user){
        userService.addUser(user);
        return "success";
    }

    @RequestMapping("/find")
    @ResponseBody
    public Object findUser(User user){
        user = userService.findUserByName(user.getUserName());
        return user;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Object list(){
        List<User> users= userService.list();
        return users;
    }

    @RequestMapping("/removeOne")
    @ResponseBody
    public Object removeOne(Integer id){
        userService.removeOne(id);
        return "success";
    }
}
