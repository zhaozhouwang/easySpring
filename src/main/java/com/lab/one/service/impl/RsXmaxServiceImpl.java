package com.lab.one.service.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
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
            String currentDayStr = getCurrentDayStr();
            RsXmax xmax = getXmaxByTypeCode(type, currentDayStr);
            if (xmax == null) {
                num = 1;
                xmax = new RsXmax().setXmaxCode(type).setXmaxVersion(num).setDateStr(currentDayStr);
                insert(xmax);
                return xmax.getXmaxVersion();
            } else {
                Integer version = xmax.getXmaxVersion();
                updateById(xmax.setXmaxVersion(version + 1));
                return xmax.getXmaxVersion();
            }
        } finally {
            lock.unlock();
        }
    }

    private RsXmax getXmaxByTypeCode(String typeCode, String dayStr) {
        EntityWrapper<RsXmax> ew = new EntityWrapper<>();
        ew.eq("XMAX_CODE", typeCode);
        ew.eq("DATE_STR", dayStr);
        return selectOne(ew);
    }


    private String getCurrentDayStr() {
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        return format.format(new Date());
    }

}
