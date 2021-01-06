package com.lab.one.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lab.one.entity.LabUser;
import com.lab.one.mapper.LabUserMapper;
import com.lab.one.service.LabUserService;
import org.springframework.stereotype.Service;

/**
 * @author wangzhaozhou
 * @date 2021/1/6
 */

@Service
public class LabUserServiceImpl extends ServiceImpl<LabUserMapper, LabUser> implements LabUserService {
}
