package com.testssm.exceptions;

/**
 * <p>
 * MybatisPlus 异常类
 * </p>
 *
 * @author hubin
 * @Date 2017-02-16
 */
public class TestssmException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TestssmException(String message) {
        super(message);
    }

    public TestssmException(Throwable throwable) {
        super(throwable);
    }

    public TestssmException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
