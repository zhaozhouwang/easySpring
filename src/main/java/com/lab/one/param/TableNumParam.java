package com.lab.one.param;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author wangzhaozhou
 * @date 2019/12/25
 */

@Data
public class TableNumParam {

    @ApiModelProperty("桌子类别 S/M/L (小中大)")
    @NotBlank(message = "桌子类别不能为空")
    private String tableType;

}
