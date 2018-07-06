package com.testssm.exception;

import com.aitou.framework.common.model.TransactionResult;
import com.aitou.framework.common.resource.MessageResourceBundle;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常处理的工具类
 */
public class ExceptionUtils {

    public static TransactionResult parseException(Exception e) {
        String errorMessage;
        String errorCode;
        if(e instanceof ExecutionException) {
            errorCode = ((ExecutionException)e).getErrorCode();
            errorMessage = MessageResourceBundle.getMessage(((ExecutionException)e).getErrorCode());
            if(errorMessage == null) {
                errorMessage = e.getMessage();
            }
        } else {
            errorCode = "UNKNOWN_ERROR";
            errorMessage = "系统发生未知异常！";
        }
        return new TransactionResult(errorCode, errorMessage);
    }

    public static String exceptionToString(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        StringBuilder errorBuilder = new StringBuilder(e.getClass().getName());
        errorBuilder.append(":").append(e.getMessage()).append("\r\n").append(sw.toString()).append("\r\n");
        return errorBuilder.toString();
    }

    public static String getCallStackTraceByException(Throwable t) {
        return getCallStackTraceByException(t, Integer.MAX_VALUE);
    }

    public static String getCallStackTraceByException(Throwable t, int topN) {
        StackTraceElement[] stackTraceElements = t.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<stackTraceElements.length && i<topN; i++) {
            if(i > 0)
                sb.append("\n");
            sb.append(printStackTraceElement(stackTraceElements[i]));
        }
        return sb.toString();
    }

    private static String printStackTraceElement(StackTraceElement element) {
        return element.getClassName() + "#" + element.getMethodName() + "(" + element.getLineNumber() + ")";
    }

}
