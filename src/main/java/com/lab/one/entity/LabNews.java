package com.lab.one.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.lab.one.utils.DateUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author simeixue
 * @date 2021/1/6
 */

@Data
@Accessors(chain = true)
@TableName("LabNews")
public class LabNews {

    /**
     * PK
     */
    @TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty("id")
    private String id;


    /**
     * title
     */
    @TableField("title")
    @ApiModelProperty("title")
    private String title;


    /**
     * 密码
     */
    @TableField("newsDetail")
    @ApiModelProperty("newsDetail")
    private String newsDetail;


    @TableField("createTime")
    @ApiModelProperty("createTime")
    private Date createTime;

    @TableField(exist = false)
    private String createTimeStr;

    public String getCreateTimeStr() {
        return DateUtil.getNormalTimeStr(createTime);
    }
}
