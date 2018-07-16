package com.testssm.exception;



/**
 * 业务逻辑类型的异常，用于由于用户的操作引起的异常。对于非用户造成的异常使用SystemException及其子类。
 */
public class BusinessException extends ExecutionException {
	
	public BusinessException(String errorCode) {
		super(errorCode);
	}

    public BusinessException(String errorCode, String defaultMessage) {
        super(errorCode, defaultMessage);
    }

    public BusinessException(String errorCode, String defaultMessage, Throwable cause) {
        super(errorCode, defaultMessage, cause);
    }


}
