package com.lab.one.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.lab.one.entity.LabUser;
import com.lab.one.mapper.LabUserMapper;
import com.lab.one.service.LabUserService;
import com.lab.one.vo.LoginParam;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author wangzhaozhou
 * @date 2021/1/6
 */

@Service
public class LabUserServiceImpl extends ServiceImpl<LabUserMapper, LabUser> implements LabUserService {

    @Override
    public String userLogin(LoginParam param) {
        EntityWrapper<LabUser> ew = new EntityWrapper<>();
        ew.eq("username", param.getUsername());
        ew.eq("password", param.getPassword());
        LabUser labUser = selectOne(ew);
        if (labUser == null) {
            return null;
        }
        String currentToken = labUser.getCurrentToken();
        if (StringUtils.isNotEmpty(currentToken)) {
            return currentToken;
        }
        String newToken = UUID.randomUUID().toString().replace("-", "");
        updateById(labUser.setCurrentToken(newToken));
        return newToken;
    }

    @Override
    public boolean checkTokenAccess(String token) {
        if (StringUtils.isNotEmpty(token)) {
            EntityWrapper<LabUser> ew = new EntityWrapper<>();
            ew.eq("currentToken", token);
            return selectCount(ew) > 0;
        }
        return false;
    }
}
