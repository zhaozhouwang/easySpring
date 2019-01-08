package com.lab.one.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lab.one.entity.User;
import com.lab.one.vo.UserResult;

/**
 * <p>
 * UserMapper接口
 * </p>
 *
 * @author Mr.One
 * @date 2018/12/25
 */
public interface UserMapper extends BaseMapper<User> {

    List<UserResult> queryUser(String queryParam);
}
