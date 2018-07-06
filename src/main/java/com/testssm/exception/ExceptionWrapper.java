package com.testssm.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 异常的包装类，主要用于将CheckedException包装为ExecutionException体系中。
 */
@SuppressWarnings("serial")
public class ExceptionWrapper extends ExecutionException {

    public ExceptionWrapper(Throwable cause) {
        super(cause);
    }
    
    public ExceptionWrapper(String message, Throwable cause) {
    	super(message, cause);
    }

    public ExceptionWrapper(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    @Override
    public String getExceptionType() {
        return super.getCause().getClass().getName();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return getCause().getStackTrace();
    }

    /**
     * 覆盖打印堆栈信息，将忽略掉ExceptionWrapper的本身的堆栈信息。
     */
    public void printStackTrace(PrintStream s) {
        s.print(getMessage());
        s.println(", The Exception is: ");
        super.getCause().printStackTrace(s);
    }

    /**
     * 覆盖打印堆栈信息，将忽略掉ExceptionWrapper的本身的堆栈信息。
     */
    public void printStackTrace(PrintWriter s) {
        s.print(getMessage());
        s.println(", The Exception is: ");
        super.getCause().printStackTrace(s);
    }
}
