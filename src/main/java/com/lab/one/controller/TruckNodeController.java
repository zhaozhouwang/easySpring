package com.lab.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.one.controller.base.BaseController;
import com.lab.one.entity.BoxAddr;
import com.lab.one.service.BoxAddrService;
import com.lab.one.utils.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boxAddr", value = "地址", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "lng", value = "经度", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "lat", value = "纬度", dataType = "String", paramType = "query")
    })
    @GetMapping("/box")
    public Response insertBoxAddr() {
        BoxAddr addr = new BoxAddr();
        addr.setBoxAddr(request.getParameter("boxAddr"))
                .setLat(request.getParameter("lat"))
                .setLng(request.getParameter("lng"))
                .setOrderId("123")
                .setTrigger(3000);
        boxAddrService.insert(addr);
        return Response.success(200);
    }


}
