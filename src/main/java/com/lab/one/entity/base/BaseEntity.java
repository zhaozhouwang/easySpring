package com.lab.one.entity.base;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * BaseEntity
 * </p>
 *
 * @author Mr.One
 * @date 2019-01-06
 */

@Data
@Accessors(chain = true)
public abstract class BaseEntity {

    public static final String CREATE_BY_FIELD = "createBy";
    public static final String CREATE_TIME_FIELD = "createTime";
    public static final String UPDATE_BY_FIELD = "updateBy";
    public static final String UPDATE_TIME_FIELD = "updateTime";
    public static final String DEL_FLAG_FIELD = "delFlag";

    /**
     * 创建人id
     */
    @TableField(value = "CREATE_BY", fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true)
    public String createBy;

    /**
     * 创建时间 yyyy-MM-dd
     */
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true)
    public Date createTime;

    /**
     * 更新人id
     */
    @TableField(value = "UPDATE_BY", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(hidden = true)
    public String updateBy;

    /**
     * 更新时间 yyyy-MM-dd
     */
    @TableField(value = "UPDATE_TIME", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(hidden = true)
    public Date updateTime;

    /**
     * 删除标记 0:未删除 1:已删除
     */
    @TableField(value = "DEL_FLAG", fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true)
    public Integer delFag;


}
