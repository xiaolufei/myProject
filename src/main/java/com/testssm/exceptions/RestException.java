package com.testssm.exceptions;


import com.testssm.enums.ErrorCodeEnum;

/**
 * <p>
 * RestResult 业务异常类
 * </p>
 *
 * @author hubin
 * @Date 2017-02-16
 */
public class RestException extends TestssmException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private ErrorCodeEnum errorCodeEnum;

    public RestException(String message) {
        super(message);
    }

    public RestException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMsg());
        this.errorCodeEnum = errorCodeEnum;
    }

    public ErrorCodeEnum getErrorCodeEnum() {
        return errorCodeEnum;
    }

    public void setErrorCodeEnum(ErrorCodeEnum errorCodeEnum) {
        this.errorCodeEnum = errorCodeEnum;
    }

}
