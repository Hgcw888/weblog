package com.hgcw.weblog.service.impl;

import com.hgcw.weblog.entity.User;
import com.hgcw.weblog.mapper.UserMapper;
import com.hgcw.weblog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hgcw
 * @since 2021-05-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
