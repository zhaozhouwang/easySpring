package com.lab.one.controller;

import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.lab.one.controller.base.BaseController;
import com.lab.one.service.LabUserService;
import com.lab.one.utils.Response;
import com.lab.one.vo.LoginParam;
import com.lab.one.vo.UserResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * UserController CRUD
 * </p>
 *
 * @author Mr.One
 * @date 2018/12/25
 */

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    LabUserService userService;


    @ApiOperation(value = "登录", notes = "登录", response = UserResult.class)
    @PostMapping("/public/login")
    public Response login(@RequestBody LoginParam param) {
        String token = userService.userLogin(param);
        return StringUtils.isEmpty(token) ? Response.fail() : Response.success(token);
    }

}

