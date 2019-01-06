package com.lab.one.controller.base;

import java.util.regex.Pattern;

/**
 * <p>
 * baseController
 * </p>
 *
 * @author Mr.One
 * @date 2019-01-06
 */
public class BaseController {


    /**
     * 手机号正则,'1'+ 10个数字 匹配通过
     */
    private static final String REGEX_MOBILE = "^(1)[\\d]{10}$";

    /**
     * 邮箱正则,xxx@xx.xx即可
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";


    public boolean checkMobile(String mobile) {

        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    public boolean checkEMail(String eMail) {
        return Pattern.matches(REGEX_EMAIL, eMail);
    }
}
