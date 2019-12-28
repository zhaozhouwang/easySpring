package com.lab.one.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.lab.one.entity.LabUser;
import com.lab.one.vo.UserResult;

/**
 * <p>
 * UserService接口
 * </p>
 *
 * @author Mr.One
 * @date 2018/12/25
 */
public interface UserService extends IService<LabUser> {

    boolean insertUser(LabUser labUser);


    /**
     * 根据id查询未被删除用户
     */
    LabUser selectActiveById(String id);

    /**
     * 分页查询用户列表
     */
    Page<UserResult> findUserList(Page<UserResult> page, String param);

}

