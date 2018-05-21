package com.testssm.enums;

/**
 * <p>
 * 错误码
 * </p>
 *
 * @author hubin
 * @Date 2017-02-16
 */
public enum ErrorCodeEnum {
    FAILED("0", "失败"),
    SUCCESS("1", "成功"),
    TOKEN_ERROR("-1", "失败 RestToken 错误"),
    PARAMS_ERROR("400", "参数有误"),
    NO_EXIST("404", "Not Found!"),
    USER_ID_IS_NULL("400", "用户ID为NULL"),
    SERVICE_ERROR("500", "服务器内部错误");


    private final String code;
    private final String msg;

    ErrorCodeEnum(final String code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ErrorCodeEnum getErrorCodeEnum(String errorCodeEnum) {
        ErrorCodeEnum[] ecs = ErrorCodeEnum.values();
        for (ErrorCodeEnum ec : ecs) {
            if (ec.getCode().equalsIgnoreCase(errorCodeEnum)) {
                return ec;
            }
        }
        return SUCCESS;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
