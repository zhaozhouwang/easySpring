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
 * 装箱门点地址entity
 * </p>
 *
 * @author wangzhaozhou
 * @date 2019/1/31
 */

@Data
@Accessors(chain = true)
@TableName("BOX_ADDR")
public class BoxAddr {

    /**
     * PK
     */
    @TableId(value = "BOX_ID", type = IdType.UUID)
    @ApiModelProperty("装箱门点地址ID")
    private String boxId;

    /**
     * 装箱点所属车队ID
     */
    @TableField("TRUCK_TEAM_ID")
    @ApiModelProperty("装箱点所属车队ID")
    private String truckTeamId;

    /**
     * 装箱点地址
     */
    @TableField("BOX_ADDR")
    @ApiModelProperty("装箱点地址")
    private String boxAddr;

    /**
     * 纬度
     */
    @TableField("LAT")
    @ApiModelProperty("纬度")
    private String lat;

    /**
     * 经度
     */
    @TableField("LNG")
    @ApiModelProperty("经度")
    private String lng;


    /**
     * 触发值,单位米
     */
    @TableField("TRIGGER")
    @ApiModelProperty("触发值")
    private int trigger;

    /**
     * 关联订单ID
     */
    @TableField("ORDER_ID")
    @ApiModelProperty("关联订单ID")
    private String orderId;
}
