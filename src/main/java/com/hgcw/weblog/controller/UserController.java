package com.hgcw.weblog.controller;


import com.hgcw.weblog.entity.User;
import com.hgcw.weblog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hgcw
 * @since 2021-05-09
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/selcet")
    public List<User> getId() {
        List<User> users = userMapper.selectList(null);
        return users;


    }
}
