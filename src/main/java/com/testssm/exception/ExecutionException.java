package com.testssm.exception;

/**
 * 执行过程中的异常，作为整个异常的父类。.
 */
public class ExecutionException extends RuntimeException {

    /**
     * 对外提示的错误代码
     */
    private String errorCode;

    protected ExecutionException(){
    }

    /**
     * 异常构造函数，这里仅传入异常的默认提示信息。
     * @param defaultMessage 默认的异常提示信息
     */
    protected ExecutionException(String errorCode) {
        super(errorCode);
        setErrorCode(errorCode);
    }

    protected ExecutionException(String defaultMessage, Throwable cause) {
        super(defaultMessage, cause);
    }

    protected ExecutionException(String errorCode, String defaultMessage) {
        super(defaultMessage);
        setErrorCode(errorCode);
    }

    protected ExecutionException(String errorCode, String defaultMessage, Throwable cause) {
        super(defaultMessage, cause);
        setErrorCode(errorCode);
    }

    protected ExecutionException(Throwable cause) {
        super(cause);
    }

    public String getErrorCode() {
        return errorCode;
    }

    /**
     * 得到异常的类型描述，默认是返回当前异常类的全路径名，例如：cn.rkang.flame.common.exception.ExecutionException
     */
    public String getExceptionType() {
        return this.getClass().getName();
    }

    /**
     * 设置错误代码，注意：errorCode不能未空
     * @param errorCode 错误代码
     * @throws AssertionError
     */
    protected void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
