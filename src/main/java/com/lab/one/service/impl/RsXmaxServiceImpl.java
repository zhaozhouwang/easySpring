package com.lab.one.service.impl;


import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lab.one.entity.RsXmax;
import com.lab.one.mapper.RsXmaxMapper;
import com.lab.one.service.RsXmaxService;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuxiaobin123
 * @since 2019-12-25
 */
@Service
public class RsXmaxServiceImpl extends ServiceImpl<RsXmaxMapper, RsXmax> implements RsXmaxService {

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public Integer getNextNumByType(String type) {
        lock.lock();
        try {
            Integer num;
            RsXmax xmax = getXmaxByTypeCode(type);
            if (xmax == null) {
                num = 1;
                xmax = new RsXmax().setXmaxCode(type).setXmaxVersion(num);
                insert(xmax);
                return xmax.getXmaxVersion();
            } else {
                updateById(xmax);
                return xmax.getXmaxVersion() + 1;
            }
        } finally {
            lock.unlock();
        }
    }

    private RsXmax getXmaxByTypeCode(String typeCode) {
        EntityWrapper<RsXmax> ew = new EntityWrapper<>();
        ew.eq("XMAX_CODE", typeCode);
        return selectOne(ew);
    }
}
