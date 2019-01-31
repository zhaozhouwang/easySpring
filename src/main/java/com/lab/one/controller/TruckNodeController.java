package com.lab.one.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.one.controller.base.BaseController;
import com.lab.one.entity.BoxAddr;
import com.lab.one.param.BoxAddrParam;
import com.lab.one.service.BoxAddrService;
import com.lab.one.utils.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 *
 * </p>
 *
 * @author wangzhaozhou
 * @date 2019/1/31
 */

@Api(tags = "订单节点")
@RestController
@RequestMapping("/truck")
public class TruckNodeController extends BaseController {

    @Autowired
    BoxAddrService boxAddrService;

    @ApiOperation(value = "集卡司机点选装箱点", notes = "集卡司机点选装箱点")
    @PostMapping("/box")
    public Response insertBoxAddr(@RequestBody BoxAddrParam boxAddrParam) {
        BoxAddr addr = new BoxAddr();
        BeanUtils.copyProperties(boxAddrParam, addr);
        addr.setOrderId("123")
                .setTrigger(3000);
        boxAddrService.insert(addr);
        return Response.success();
    }



}
