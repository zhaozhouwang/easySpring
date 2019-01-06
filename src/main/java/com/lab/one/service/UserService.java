package com.lab.one.service;

import com.baomidou.mybatisplus.service.IService;
import com.lab.one.entity.User;

/**
 * <p>
 *
 * </p>
 *
 * @author Mr.One
 * @date 2018/12/25
 */
public interface UserService extends IService<User> {

    boolean insertUser(User user);

}
