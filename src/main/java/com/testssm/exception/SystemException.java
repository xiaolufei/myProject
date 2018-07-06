package com.testssm.exception;

/**
 * 系统级别的运行异常，用于非用户引起的异常，例如：调用外部服务超时。
 *
 * 系统异常建议尽量使用子类，而非当前类，例如：RuntimeException与NullPointerException的关系。
 */
public class SystemException extends ExecutionException {

    public SystemException(String errorCode) {
        super(errorCode);
    }

    public SystemException(String errorCode, String defaultMessage) {
        super(errorCode, defaultMessage);
    }

    public SystemException(String errorCode, String defaultMessage, Throwable cause) {
        super(errorCode, defaultMessage, cause);
    }

}
