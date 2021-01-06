package com.lab.one.aop;


import com.lab.one.handle.AuthException;
import com.lab.one.service.LabUserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangzhaozhou
 * @date 2020/9/23
 */

@Aspect
@Component
public class SwmsAuthAspect {

    private static final String REQUEST_BEGIN_TS = "beginTs";


    @Autowired
    LabUserService userService;

    private static final String Authorization = "token";

    @Pointcut("execution(* com.lab.one.controller..*.*(..))")
    public void executeService() {

    }

    @Before(value = "executeService()")
    public void beforeQueryCont(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String url = request.getRequestURL().toString();
        if (url.contains("public")) {
            return;
        }
        String requestToken = request.getParameter("token");
        userService.checkTokenAccess(requestToken);
        if (!userService.checkTokenAccess(requestToken)) {
            throw new AuthException("invalid token");
        }

    }


}
