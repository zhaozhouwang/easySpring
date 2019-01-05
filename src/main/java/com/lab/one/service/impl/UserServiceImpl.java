package com.lab.one.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lab.one.entity.User;
import com.lab.one.mapper.UserMapper;
import com.lab.one.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author wangzhaozhou
 * @date 2018/12/25
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean insertUser(User user) {
        return insert(user);

    }
}
