package com.lab.one.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.lab.one.entity.User;
import com.lab.one.mapper.UserMapper;
import com.lab.one.service.UserService;

/**
 * <p>
 * UserService实现类
 * </p>
 *
 * @author Mr.One
 * @date 2018/12/25
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean insertUser(User user) {
        return insert(user);

    }

    @Override
    public User selectActiveById(String id) {
        EntityWrapper<User> ew = new EntityWrapper<>();
        ew.eq("ID", id);
        ew.eq("DEL_FLAG", 0);
        return selectOne(ew);
    }

    @Override
    public Page<User> findUserList(Page<User> page, String param) {
        EntityWrapper<User> ew = new EntityWrapper<>();
        ew.eq("DEL_FLAG", 0);
        if (StringUtils.isEmpty(param)) {
            ew.orderBy("USERNAME");
            return selectPage(page, ew);
        }
        String queryParam = "%" + param.trim() + "%";
        List<User> result = baseMapper.queryUser(queryParam);
        return page.setRecords(result);
    }
}
