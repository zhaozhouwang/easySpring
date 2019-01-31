package com.lab.one.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author wangzhaozhou
 * @date 2019/1/31
 */

@Data
@Accessors(chain = true)
@TableName("ORDER")
public class Order {

    /**
     * PK
     */
    @TableId(value = "ORDER_ID", type = IdType.UUID)
    @ApiModelProperty("订单id")
    private String orderId;

    /**
     * 集卡司机
     */
    @TableField("TRUCK_DRIVER")
    @ApiModelProperty("集卡司机")
    private String truckDriver;

    /**
     * 车状态
     */
    @TableField("TRUCK_NODE")
    @ApiModelProperty("车状态")
    private String truckNode;


}
