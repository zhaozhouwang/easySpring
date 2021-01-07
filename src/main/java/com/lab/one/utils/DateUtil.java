package com.lab.one.utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author simeixue
 * @date 2020/01/06
 */
public abstract class DateUtil {


    private final static String NORMAL_TIME_REGEX = "yyyy-MM-dd HH:mm:ss";

    public static String getDateStr(int num, String regex) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, num);
        return new SimpleDateFormat(regex).format(calendar.getTime());
    }


    public static Map<String, Integer> getNear12MonthMap(String regex) {
        Map<String, Integer> map = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -11);
        SimpleDateFormat format = new SimpleDateFormat(regex);
        map.put(format.format(calendar.getTime()), 1);

        for (int i = 1; i < 12; i++) {
            calendar.add(Calendar.MONTH, 1);
            map.put(format.format(calendar.getTime()), i + 1);
        }
        return map;
    }

    public static String getTimeStr(Date date, String regex) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(regex);
        return format.format(date);
    }

    /**
     * 获取指定时间的date  以当前系统日期为基准
     *
     * @param dayNum  0为当天,-1为昨日  1为明天  以此类推
     * @param hourNum 指定小时 0-24
     */
    public static Date getSpecifiedDate(int dayNum, int hourNum, int minNum) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, dayNum);
        calendar.set(Calendar.HOUR_OF_DAY, hourNum);
        calendar.set(Calendar.MINUTE, minNum);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date generateUnionpayExpireTime(int minNum) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, minNum);
        return calendar.getTime();
    }

    public static String getNormalTimeStr(Date date) {
        if (date == null) {
            return "-";
        }
        SimpleDateFormat format = new SimpleDateFormat(NORMAL_TIME_REGEX);
        return format.format(date);
    }

    public static String getMsrUUID(String head) {
        String timeStr = getTimeStr(new Date(), "yyMMdd");
        String uuidStr = UUID.randomUUID().toString().replace("-", "").substring(0, 12);
        return head + timeStr + uuidStr + (int) (Math.random() * 10);
    }


    public static Date transferDateStamp(String timestamp) {
        long lt = new Long(timestamp);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(lt));
        return new Date(lt);
    }
}
