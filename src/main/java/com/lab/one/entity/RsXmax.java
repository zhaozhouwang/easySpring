package com.lab.one.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author yuxiaobin123
 * @since 2019-12-25
 */
@Data
@Accessors(chain = true)
@TableName("RS_XMAX")
public class RsXmax {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.UUID)
    private String id;

    @TableField("XMAX_CODE")
    private String xmaxCode;

    @TableField("DATE_STR")
    private String dateStr;

    @TableField("XMAX_VERSION")
    private Integer xmaxVersion;


}
