package com.lab.one.controller;

import com.lab.one.entity.User;
import com.lab.one.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author wangzhaozhou
 * @date 2018/12/25
 */

@Api(value = "用户管理", description = "用户管理")
//@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @ApiOperation(value = "新增用户",notes = "新增用户")
    @PostMapping("/insert")
    public String insertUser() {
        User user = new User();
        user.setName("One")
                .setAge("18")
                .setUsername("Mr.One")
                .setPassword("abc123");
        boolean result = userService.insertUser(user);
        if (result) {
            return "success";
        } else {
            return "fail";
        }
    }

    @ApiOperation(value = "查找用户",notes = "查找用户")
    @GetMapping("/insert")
    public String insertUserget() {

        return null;
    }

}
