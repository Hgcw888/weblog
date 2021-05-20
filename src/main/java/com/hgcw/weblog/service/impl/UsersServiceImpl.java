package com.hgcw.weblog.service.impl;

import com.hgcw.weblog.entity.Users;
import com.hgcw.weblog.mapper.UsersMapper;
import com.hgcw.weblog.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户  服务实现类
 * </p>
 *
 * @author hgcw
 * @since 2021-05-18
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
