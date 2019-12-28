package com.lab.one.entity;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.lab.one.entity.base.BaseEntity;
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
@EqualsAndHashCode(callSuper = true)
@TableName("LAB_USER")
public class LabUser extends BaseEntity {


    /**
     * PK
     */
    @TableId(value = "ID", type = IdType.UUID)
    @ApiModelProperty("id")
    private String id;

    /**
     * 真实姓名
     */
    @TableField("REAL_NAME")
    @ApiModelProperty("真实姓名")
    private String realName;

    /**
     * 年龄
     */
    @TableField("AGE")
    @ApiModelProperty("年龄")
    private Integer age;

    /**
     * 生日
     */
    @TableField("BIRTHDAY")
    @ApiModelProperty("生日")
    private Date birthday;

    /**
     * 用户名,昵称
     */
    @TableField("USERNAME")
    @ApiModelProperty("用户名,昵称")
    private String username;

    /**
     * 手机号码
     */
    @TableField("MOBILE")
    @ApiModelProperty("手机号码")
    private String mobile;


    /**
     * 邮箱
     */
    @TableField("E_MAIL")
    @ApiModelProperty("邮箱")
    private String eMail;



    /**
     * 密码
     */
    @TableField("PASSWORD")
    @ApiModelProperty("密码")
    private String password;

    /**
     * 盐
     */
    @TableField("SALT")
    @ApiModelProperty(hidden = true)
    private String salt;

}

