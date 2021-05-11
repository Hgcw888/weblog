package com.hgcw.weblog.mapper;

import com.hgcw.weblog.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hgcw
 * @since 2021-05-09
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}
