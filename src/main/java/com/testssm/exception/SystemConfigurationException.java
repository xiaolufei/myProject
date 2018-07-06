package com.testssm.exception;

/**
 * 系统配置错误的异常
 * @author Zeng Raoxing
 */
public class SystemConfigurationException extends SystemException {

	public SystemConfigurationException(String message) {
		super(null, message);
	}
	public SystemConfigurationException(String message, Throwable e) {
		super(null, message, e);
	}

}
