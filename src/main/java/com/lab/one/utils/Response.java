package com.lab.one.utils;

import java.util.HashMap;

/**
 * <p>
 * Controllers全局统一返回类
 * </p>
 *
 * @author Mr.One
 * @date 2019-01-06
 */
public class Response extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    private static final String MSG = "msg";

    private static final String SUCCESS = "success";

    private static final String FAIL = "fail";

    private static final String DATA = "data";

    private static final String ERROR = "error";

    private static final HashMap<String, Object> MAP = new HashMap<>();


    private Response() {

    }

    private Response(String msg, HashMap<String, Object> date) {
        put(MSG, msg);
        put(DATA, date);
    }

    private Response(String msg) {
        put(MSG, msg);
    }


    public static Response success() {
        return new Response(SUCCESS, MAP);
    }

    public static Response success(Object object) {
        Response response = new Response(SUCCESS);
        MAP.put(DATA, object);
        response.putAll(MAP);
        return response;

    }

    public static Response fail() {
        return new Response(FAIL);
    }


    public static Response fail(String msg) {
        Response response = new Response(FAIL);
        response.put(ERROR, msg);
        return response;
    }



}
