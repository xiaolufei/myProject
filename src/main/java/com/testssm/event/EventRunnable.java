package com.testssm.event;


import com.testssm.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 异步事件处理器
 */
public class EventRunnable implements Runnable {
    protected static Logger logger = LoggerFactory.getLogger(EventRunnable.class);
    private TransactionEvent event;
    private Set<EventHandler> eventHandlerSet;

    public EventRunnable(TransactionEvent event, Set<EventHandler> eventHandlerSet) {
        this.event = event;
        this.eventHandlerSet = eventHandlerSet;
    }

    public TransactionEvent getEvent() {
        return event;
    }

    public Set<EventHandler> getEventHandlerSet() {
        return eventHandlerSet;
    }

    @Override
    public void run() {
        beforeHandle();
        List<Exception> exceptionList = null;
        for(EventHandler eventHandler: eventHandlerSet) {
            try {
            	logger.info("事件[" + event + "]开始处理");
                eventHandler.handleEvent(event);
            } catch (Exception e) {
                if(exceptionList == null) {
                    exceptionList = new ArrayList<>();
                }
                exceptionList.add(e);
                logger.warn("事件[" + event + "]处理中发生错误：", e);
            }
        }
        afterHandle(exceptionList);
    }

    /**
     * 子类可进行扩展
     */
    protected  void beforeHandle() {
        if(logger.isDebugEnabled()) {
            logger.debug("事件[" + event.getType() + "]开始处理！");
        }
    }

    protected void afterHandle(List<Exception> exceptionList) {
        if(exceptionList == null) {
            logger.debug("事件[" + event.getType() + "]处理完成！");
        } else {
            logger.warn("事件[" + event + "]处理完成，但期间发生了错误：" + getExceptions(exceptionList));
        }
    }

    /**
     * 工具方法，提供将所有异常转换为字符串的方法
     * @param exceptionList
     * @return
     */
    protected String getExceptions(List<Exception> exceptionList) {
        StringBuilder exceptionBuilder = new StringBuilder();
        for(Exception e: exceptionList) {
            if(exceptionBuilder.length() > 0) {
                exceptionBuilder.append(e).append("\n").append(ExceptionUtils.exceptionToString(e));
            }
        }
        return exceptionBuilder.toString();
    }

}