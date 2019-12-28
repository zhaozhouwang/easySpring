package com.lab.one.controller;

import com.lab.one.entity.LabUser;
import com.lab.one.vo.param.UserAddParam;
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
import com.lab.one.service.UserService;
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
    UserService userService;


    @ApiOperation(value = "新增用户", notes = "新增用户")
    @PostMapping("")
    public Response insertUser(@RequestBody @Validated UserAddParam param) {

        if (!checkMobile(param.getMobile())) {
            return Response.fail(ResponseErrorEnum.MOBILE_ERROR.getErrorDesc());
        }
        if (!checkEMail(param.getEMail())) {
            return Response.fail(ResponseErrorEnum.EMAIL_ERROR.getErrorDesc());
        }
        LabUser user = new LabUser();
        BeanUtils.copyProperties(param, user);
        user.setDelFag(0);
        if (userService.insertUser(user)) {
            return Response.success();
        }
        return Response.fail(ResponseErrorEnum.USER_INSERT_ERROR.getErrorDesc());
    }


    @ApiOperation(value = "获得单个用户", notes = "获得用户", response = UserResult.class)
    @GetMapping("/{id}")
    public Response findUserById(@PathVariable(value = "id") String id) {
        LabUser labUser = userService.selectActiveById(id);
        if (labUser == null) {
            return Response.fail(ResponseErrorEnum.USER_EXIST_ERROR.getErrorDesc());
        }
        UserResult result = new UserResult();
        BeanUtils.copyProperties(labUser, result);
        return Response.success(result);
    }


    @ApiOperation(value = "更新用户", notes = "更新用户")
    @PutMapping("")
    public Response updateUser(@RequestBody @Validated LabUser labUser) {
        String id = labUser.getId();
        if (StringUtils.isEmpty(id)) {
            return Response.fail(ResponseErrorEnum.ID_EMPITY_ERROR.getErrorDesc());
        }
        LabUser dbLabUser = userService.selectActiveById(id);
        if (dbLabUser == null) {
            return Response.fail(ResponseErrorEnum.USER_EXIST_ERROR.getErrorDesc());
        }
        BeanUtils.copyProperties(labUser, dbLabUser);
        //todo 密码 salt处理
        userService.updateById(dbLabUser);
        return Response.success();
    }

    @ApiOperation(value = "查询用户/获得用户列表", notes = "查询用户", response = UserResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "queryParam", value = "查询条件,不传查全部", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页,不传默认第一页", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "当前页记录条数,不传默认10条", dataType = "String", paramType = "query")
    })
    @GetMapping("")
    public Response queryUser() {
        String param = request.getParameter("queryParam");
        Integer[] pageInfo = getPageInfo();
        Page<UserResult> page = new Page<>(pageInfo[0], pageInfo[1]);

        return Response.success(userService.findUserList(page, param));
    }


    @ApiOperation(value = "删除用户", notes = "删除用户", response = UserResult.class)
    @DeleteMapping("/{id}")
    public Response delUserById(@PathVariable(value = "id") String id) {
        if (StringUtils.isEmpty(id)) {
            return Response.fail(ResponseErrorEnum.ID_EMPITY_ERROR.getErrorDesc());
        }

        LabUser labUser = userService.selectById(id);
        if (labUser == null) {
            return Response.fail(ResponseErrorEnum.USER_EXIST_ERROR.getErrorDesc());
        }
        labUser.setDelFag(1);
        userService.updateById(labUser);
        return Response.success();
    }

}

