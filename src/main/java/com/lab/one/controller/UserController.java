package com.lab.one.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.lab.one.controller.base.BaseController;
import com.lab.one.entity.User;
import com.lab.one.enums.ResponseErrorEnum;
import com.lab.one.service.UserService;
import com.lab.one.utils.Response;
import com.lab.one.vo.UserResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public Response insertUser(@RequestBody @Validated User user) {

        if (!checkMobile(user.getMobile())) {
            return Response.fail(ResponseErrorEnum.MOBILE_ERROR.getErrorDesc());
        }
        if (!checkEMail(user.getEMail())) {
            return Response.fail(ResponseErrorEnum.EMAIL_ERROR.getErrorDesc());
        }
        user.setDelFag(0);
        if (userService.insertUser(user)) {
            return Response.success();
        }
        return Response.fail(ResponseErrorEnum.USER_INSERT_ERROR.getErrorDesc());
    }


    @ApiOperation(value = "获得单个用户", notes = "获得用户", response = UserResult.class)
    @GetMapping("/{id}")
    public Response findUserById(@PathVariable(value = "id") String id) {
        User user = userService.selectActiveById(id);
        if (user == null) {
            return Response.fail(ResponseErrorEnum.USER_EXIST_ERROR.getErrorDesc());
        }
        UserResult result = new UserResult();
        BeanUtils.copyProperties(user, result);
        return Response.success(result);
    }


    @ApiOperation(value = "更新用户", notes = "更新用户")
    @PutMapping("")
    public Response updateUser(@RequestBody @Validated User user) {
        String id = user.getId();
        if (StringUtils.isEmpty(id)) {
            return Response.fail(ResponseErrorEnum.ID_EMPITY_ERROR.getErrorDesc());
        }
        User dbUser = userService.selectActiveById(id);
        if (dbUser == null) {
            return Response.fail(ResponseErrorEnum.USER_EXIST_ERROR.getErrorDesc());
        }
        BeanUtils.copyProperties(user, dbUser);
        //todo 密码 salt处理
        userService.updateById(dbUser);
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

        User user = userService.selectById(id);
        if (user == null) {
            return Response.fail(ResponseErrorEnum.USER_EXIST_ERROR.getErrorDesc());
        }
        user.setDelFag(1);
        userService.updateById(user);
        return Response.success();
    }

    @ApiOperation(value = "excel批量导入", notes = "excel批量导入")
    @PostMapping("/excel")
    public Response insertUserByExcel(@RequestBody MultipartFile file) throws Exception{
        String fileName = file.getOriginalFilename();
        if (StringUtils.isEmpty(fileName)) {
            return Response.fail("gun");
        }
        if (!fileName.toLowerCase().endsWith("xlsx")) {
            return Response.fail("需要excel文件");

        }
        boolean isSuccess = userService.insertBatchByExcel(file);

        return Response.success();
    }
}

