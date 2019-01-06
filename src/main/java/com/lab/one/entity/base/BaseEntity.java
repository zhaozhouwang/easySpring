package com.lab.one.entity.base;

import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * BaseEntity
 * </p>
 *
 * @author wangzhaozhou
 * @date 2019-01-06
 */

@Data
@Accessors(chain = true)
public class BaseEntity {

    /**
     * 创建人id
     */
    @TableField("CREATE_BY")
    @ApiModelProperty(hidden = true)
    public String createBy;

    /**
     * 创建时间 yyyy-MM-dd
     */
    @TableField("CREATE_TIME")
    @ApiModelProperty(hidden = true)
    public Date createTime;

    /**
     * 更新人id
     */
    @TableField("UPDATE_BY")
    @ApiModelProperty(hidden = true)
    public String updateBy;

    /**
     * 更新时间 yyyy-MM-dd
     */
    @TableField("UPDATE_TIME")
    @ApiModelProperty(hidden = true)
    public Date updateTime;

    /**
     * 删除标记 0:未删除 1:已删除
     */
    @TableField("DEL_FLAG")
    @ApiModelProperty(hidden = true)
    public Integer delFag;


}
