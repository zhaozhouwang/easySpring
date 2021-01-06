package com.lab.one.controller;

import com.lab.one.entity.LabUser;
import com.lab.one.service.LabUserService;
import com.lab.one.vo.LoginParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.lab.one.controller.base.BaseController;
import com.lab.one.enums.ResponseErrorEnum;
import com.lab.one.utils.Response;
import com.lab.one.vo.UserResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

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
    @PostMapping("/login")
    public Response login(LoginParam param) {
        System.out.println(param.getPassword());
        return Response.fail(param.getUsername());
    }

}

