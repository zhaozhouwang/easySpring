package com.lab.one.vo;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户返回类result
 * </p>
 *
 * @author wangzhaozhou
 * @date 2019-01-06
 */

@Data
@Accessors(chain = true)
public class UserResult {

    /**
     * PK
     */
    private String id;


    /**
     * 真实姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 用户名,昵称
     */
    private String username;


    /**
     * 邮箱
     */
    private String eMail;

}
