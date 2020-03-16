package com.lab.one.vo.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Accessors(chain = true)
public class UserAddParam {

    /**
     * 真实姓名
     */
    @ApiModelProperty("真实姓名")
    @NotBlank(message = "姓名不能为空")
    private String realName;

    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;

    /**
     * 生日
     */
    @ApiModelProperty("生日")
    private Date birthday;

    /**
     * 用户名,昵称
     */
    @ApiModelProperty("用户名,昵称")
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    @NotBlank(message = "手机号码不能为空")
    private String mobile;


    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String eMail;


    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @NotBlank(message = "手机号码不能为空")
    private String password;

}
