package com.lab.one.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * User实体类
 * </p>
 *
 * @author wangzhaozhou
 * @date 2018/12/25
 */

@Data
@Accessors(chain = true)
@TableName("USER")
public class User {

    @TableId(value = "ID", type = IdType.UUID)
    private String id;

    @TableField("NAME")
    private String name;

    @TableField("AGE")
    private String age;

    @TableField("USER_NAME")
    private String username;

    @TableField("PASSWORD")
    private String password;


}

