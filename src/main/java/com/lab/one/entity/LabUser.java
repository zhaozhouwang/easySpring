package com.lab.one.entity;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * LabUser entity
 * </p>
 *
 * @author wangzhaozhou
 * @date 2018/12/25
 */


/**
 * Data自动生成set/get方法,简化代码
 * Accessors 组件中 fluent决定生成的get/set要不要加get/set前缀,chain决定set方法返回void还是this
 * EqualsAndHashCode: 解释文档 https://blog.csdn.net/zhanlanmg/article/details/50392266
 */
@Data
@Accessors(chain = true)
@TableName("LabUser")
public class LabUser {

    /**
     * PK
     */
    @TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty("id")
    private String id;


    /**
     * 用户名,昵称
     */
    @TableField("username")
    @ApiModelProperty("用户名,昵称")
    private String username;


    /**
     * 密码
     */
    @TableField("password")
    @ApiModelProperty("密码")
    private String password;


    @TableField("currentToken")
    @ApiModelProperty("currentToken")
    private String currentToken;

}

