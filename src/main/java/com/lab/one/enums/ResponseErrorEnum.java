package com.lab.one.enums;

/**
 * <p>
 * Response错误信息枚举
 * </p>
 *
 * @author simeixue
 * @date 2019-01-06
 */
public enum ResponseErrorEnum {

    MOBILE_ERROR("手机号码格式错误", "50001"),
    EMAIL_ERROR("邮箱格式错误", "50002"),
    USER_INSERT_ERROR("添加用户失败", "50003"),
    USER_EXIST_ERROR("用户不存在", "50004"),
    ID_EMPITY_ERROR("用户id不能为空", "50005"),
    USER_UPDATE_ERROR("用户更新失败", "50006");


    private String errorDesc;
    private String errorCode;

    ResponseErrorEnum(String errorDesc, String errorCode) {
        this.errorDesc = errorDesc;
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public String getErrorCode() {
        return errorCode;
    }


}
