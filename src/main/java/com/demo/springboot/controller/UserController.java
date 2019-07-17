package com.demo.springboot.controller;

import com.demo.springboot.entity.User;
import com.demo.springboot.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Author 孙孝峰
 * @Date 2019/6/19 19:44
 * @Description 查看所有用户
 *
 **/
@RequestMapping("user")
@Validated
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * @Author 孙孝峰
     * @Date 2019/6/19 19:44
     * @Description 查询所有用户
     **/
    @RequestMapping(value = "selectAll")
    public Object selectAll() {
        PageHelper.startPage(0, 15);
        PageHelper.orderBy("uid DESC ");
            return userService.seleteAll();
    }


    /**
     * @Author 孙孝峰
     * @Date 2019/6/19 19:44
     * @Description 添加用户
     **/
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public Object addUser(@RequestBody User user) {
        System.out.println(user);
        return userService.insert(user);
    }


    /**
     * @Author 孙孝峰
     * @Date 2019/6/19 19:44
     * @Description 删除用户
     **/
    @RequestMapping(value = "deleteUser")
    public Object deleteUser(@PathVariable("id")Integer id) {
        return userService.deleteByPrimaryKey(id);
    }

    /**
     * @Author 孙孝峰
     * @Date 2019/6/19 19:44
     * @Description 修改用户
     **/
    @RequestMapping(value = "updateUser")
    public Object updateUser(@Valid @RequestBody User user) {
        return userService.updateByPrimaryKeySelective(user);
    }

    /**
     * @Author 孙孝峰
     * @Date 2019/6/19 19:44
     * @Description 用户登录
     **/
    @RequestMapping(value = "userLogin")
    public Object userLogin(@Valid @RequestBody User user) {
        return userService.updateByPrimaryKeySelective(user);
    }

    /**
     * @Author 孙孝峰
     * @Date 2019/6/19 19:44
     * @Description 用户刷新Token
     **/
    @RequestMapping(value = "refresh")
    public Object refresh(@PathVariable(value = "refreshToken") String refreshToken) {
        return  userService.refreshToken(refreshToken);
    }
}
