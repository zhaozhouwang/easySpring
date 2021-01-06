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

    private String token;
}
