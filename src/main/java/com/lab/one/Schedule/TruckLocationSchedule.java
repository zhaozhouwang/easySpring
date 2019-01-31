package com.lab.one.Schedule;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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

    @Scheduled(cron = "0 */1 *  * * * ")
    public void reportCurrentByCron() {
        System.out.println("hahaha");
    }
}
