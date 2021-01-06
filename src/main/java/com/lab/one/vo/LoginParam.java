package com.lab.one.vo;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @author wangzhaozhou
 * @date 2021/1/6
 */

@Data
@Accessors(chain = true)
public class LoginParam {

    private String username;

    private String password;
}
