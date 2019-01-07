package com.lab.one.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.lab.one.entity.User;

/**
 * <p>
 * UserService接口
 * </p>
 *
 * @author Mr.One
 * @date 2018/12/25
 */
public interface UserService extends IService<User> {

    boolean insertUser(User user);


    /**
     * 根据id查询未被删除用户
     */
    User selectActiveById(String id);

    /**
     * 分页查询用户列表
     */
    Page<User> findUserList(Page<User> page, String param);
}
