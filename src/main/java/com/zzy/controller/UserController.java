package com.zzy.controller;

import com.zzy.pojo.User;
import com.zzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public User add(User user){
        System.out.println("开始新增...");
        return userService.add(user);
    }

    @RequestMapping("/update")
    public User update(User user){
        System.out.println("开始修改...");
        return userService.update(user);
    }

    @RequestMapping("/delete")
    public boolean delete(@RequestParam HashMap<String, String> map){
        System.out.println("开始删除...");
        return userService.delete(map.get("id"));
    }

    @RequestMapping("/selectAll")
    public List<User> selectAll(){
        System.out.println("开始查询所有...");
        return userService.selectAll();
    }

    @RequestMapping("/selectById")
    public Object selectById(@RequestParam HashMap<String, String> map){
        System.out.println("开始根据id查找...");
        return userService.selectById(map.get("id"));
    }
}
