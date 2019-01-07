package com.lab.one.controller.base;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.toolkit.StringUtils;

/**
 * <p>
 * baseController
 * </p>
 *
 * @author Mr.One
 * @date 2019-01-06
 */
public class BaseController {

    protected final org.slf4j.Logger logger =
            LoggerFactory.getLogger(this.getClass().getSimpleName());


    public static final String REQUEST_HEAD_PAGE = "page";
    public static final String REQUEST_HEAD_SIZE = "size";


    @Autowired(required = false)
    protected HttpServletRequest request;
    @Autowired(required = false)
    protected HttpServletResponse response;

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

    protected Integer[] getPageInfo() {
        String pageStr = request.getParameter(REQUEST_HEAD_PAGE);
        String sizeStr = request.getParameter(REQUEST_HEAD_SIZE);

        int page = 1;
        int size = 10;
        if (!StringUtils.isEmpty(pageStr)) {
            try {
                page = Integer.parseInt(pageStr);
            } catch (Exception e) {
            }
        }
        if (!StringUtils.isEmpty(pageStr)) {
            try {
                size = Integer.parseInt(sizeStr);
            } catch (Exception e) {
            }
        }
        return new Integer[]{page, size};
    }


}
