package com.testssm.result;


import com.testssm.enums.ErrorCodeEnum;
import com.testssm.exceptions.RestException;

/**
 * <p>
 * API REST 返回结果
 * </p>
 *
 * @author hubin
 * @since 2017-02-12
 */
public class RestResult<T> {

    // 业务错误码
    private String code;
    // 结果集
    private T data;
    // 描述
    private String msg;

    public RestResult() {
        // to do nothing
    }

    public RestResult(ErrorCodeEnum errorCodeEnum) {
        if (errorCodeEnum == null) {
            errorCodeEnum = ErrorCodeEnum.FAILED;
        }
        this.code = errorCodeEnum.getCode();
        this.msg = errorCodeEnum.getMsg();
    }

    public boolean isSuccess() {
        return "1".equals(this.code);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T servcieData() {
        if (!isSuccess()) {
            throw new RestException(ErrorCodeEnum.getErrorCodeEnum(code));
        }
        return getData();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
