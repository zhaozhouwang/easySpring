package com.lab.one.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * SayHello demo
 * </p>
 *
 * @author Mr.One
 * @date 2018/12/25
 */

@RestController
@RequestMapping("/demo")
public class HelloController {


    @Value("${name}")
    private String name;

    @GetMapping("/hello")
    public String sayHello() {
        return "hello world" + name;
    }
}
