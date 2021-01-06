package com.lab.one.handle;

import com.lab.one.utils.Response;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 全局异常处理类
 * </p>
 *
 * @author wangzhaozhou
 * @date 2020/7/14
 */
@ControllerAdvice
@Component
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object handle(Exception exception) {
        exception.printStackTrace();
        if (exception instanceof AuthException) {
            return Response.fail(exception.getMessage());
        }

        return Response.fail("service unavailable");

    }

}
