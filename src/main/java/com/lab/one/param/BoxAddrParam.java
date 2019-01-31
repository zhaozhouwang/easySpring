package com.lab.one.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 司机点选装箱点地址Param
 * </p>
 *
 * @author wangzhaozhou
 * @date 2019/1/31
 */

@Data
public class BoxAddrParam {

    @ApiModelProperty("地址")
    private String boxAddr;

    @ApiModelProperty("经度")
    private String lng;

    @ApiModelProperty("纬度")
    private String lat;

}
