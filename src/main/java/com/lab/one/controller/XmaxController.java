package com.lab.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.one.controller.base.BaseController;
import com.lab.one.param.TableNumParam;
import com.lab.one.service.RsXmaxService;
import com.lab.one.utils.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 *
 * </p>
 *
 * @author wangzhaozhou
 * @date 2019/12/25
 */

@Api(tags = "餐厅取号")
@RestController
@RequestMapping("/xmax")
public class XmaxController extends BaseController {

    @Autowired
    RsXmaxService xmaxService;

    @ApiOperation(value = "根据桌子类别取号", notes = "根据桌子类别取号")
    @GetMapping("/table")
    public Response getNum(@Validated TableNumParam param) {
        return Response.success(xmaxService.getNextNumByType(param.getTableType()));
    }

}
