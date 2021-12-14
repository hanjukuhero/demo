package com.demo.mybatisplus.mapper;

import com.demo.mybatisplus.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author hanjuku
 * @since 2021-12-13
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> selectUser(@Param("username") String username);
}
