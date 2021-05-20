package com.hgcw.weblog.controller;


import com.hgcw.weblog.common.lang.Result;
import com.hgcw.weblog.entity.User;
import com.hgcw.weblog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("index")
    public Result index(){
      User user = userMapper.selectById(1L);
      return Result.succ(user);
  }
}
