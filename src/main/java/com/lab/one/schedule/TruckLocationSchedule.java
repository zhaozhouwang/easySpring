package com.lab.one.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lab.one.entity.BoxAddr;
import com.lab.one.service.BoxAddrService;
import com.lab.one.utils.LocationUtil;

/**
 * <p>
 *
 * </p>
 *
 * @author wangzhaozhou
 * @date 2019/1/31
 */

@Component
@Configurable
@EnableScheduling
public class TruckLocationSchedule {


    private double carLat = 8.01D;
    private double carLng = 8.01D;

    @Autowired
    BoxAddrService boxAddrService;

    @Scheduled(cron = "*/5 * * * * ?")
    public void carMove() {
        carLat = carLat + 0.01;
        carLng = carLng + 0.01;
    }


    @Scheduled(cron = "*/5 * * * * ?")
    public void reportCurrentByCron() {
        BoxAddr boxAddr = boxAddrService.selectById("af7ffdef4a1e4327bb3e9f7843ad2dbc");
        double distance = LocationUtil.getDistance(Double.parseDouble(boxAddr.getLat()), Double.parseDouble(boxAddr.getLng()), carLat, carLng);
        System.out.println("默认阈值为300000,现与坐标距离为:" + distance);
        if (distance <= boxAddr.getTrigger()) {
            System.out.println(",距离小于300000,更新状态为已提箱");
            boxAddr.setTruckNode("已提箱");
            boxAddrService.updateById(boxAddr);
        }
    }
}
