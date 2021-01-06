package com.lab.one.service;

import com.baomidou.mybatisplus.service.IService;
import com.lab.one.entity.LabUser;
import com.lab.one.vo.LoginParam;

/**
 * @author wangzhaozhou
 * @date 2021/1/6
 */
public interface LabUserService extends IService<LabUser> {

    String userLogin(LoginParam param);

    boolean checkTokenAccess(String token);

}
