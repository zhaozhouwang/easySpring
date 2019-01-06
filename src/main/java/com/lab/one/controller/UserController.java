package com.lab.one.controller;

import com.lab.one.entity.User;
import com.lab.one.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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


    @ApiOperation(value = "新增用户", notes = "新增用户")
    @PostMapping("")
    public String insertUser(@RequestBody @Validated User user) {
        return userService.insertUser(user) ? "success" : "fail";
    }

    @ApiOperation(value = "查找用户", notes = "查找用户")
    @GetMapping("/{id}")
    public String findUser(@PathVariable(value = "id") String id) {
        User user = userService.selectById(id);
        return null;
    }

    @ApiOperation(value = "更新用户", notes = "更新用户")
    @PutMapping("")
    public String updateUser(@RequestBody @Validated User user) {
        return userService.insertUser(user) ? "success" : "fail";
        //TODO
    }



}
