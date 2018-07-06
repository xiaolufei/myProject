package com.testssm.event;


import com.testssm.async.AsyncTaskDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * 事件分发器
 * 建议不要直接使用此分发器，原因是：此分发器没有对消息进行持久化，对于后续做交易补偿会有一些性能问题
 */
public abstract class EventDispatcher implements AsyncEventGuardian {
    @Autowired
    private AsyncTaskDispatcher taskDispatcher;
    private Map<String, Set<EventHandler>> eventHandlerMap = Collections.EMPTY_MAP;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    public void setEventHandlerList(List<EventHandler> eventHandlerList) {
        if(eventHandlerList != null && !eventHandlerList.isEmpty()) {
            eventHandlerMap = new HashMap<>(eventHandlerList.size());
            for(EventHandler handler : eventHandlerList) {
                for(String eventType: handler.listenEventTypes()) {
                    Set<EventHandler> typeHandlerSet = eventHandlerMap.get(eventType);
                    if(typeHandlerSet == null) {
                        typeHandlerSet = new HashSet<>();
                        eventHandlerMap.put(eventType, typeHandlerSet);
                    }
                    typeHandlerSet.add(handler);
                }
            }
            logger.debug("已找到的EventHandlerMap：" + eventHandlerMap);
        } else {
            logger.error("eventHandlerList为空，无法设置！");
        }
    }

    /**
     * 创建事件并提交事件
     * @param eventType          事件类型
     * @param sourceObjectType  事件源对象类型
     * @param sourceObjectId    事件源对象ID
     */
    public void createAndPost(String eventType, String sourceObjectType, String sourceObjectId) {
        createAndPost(eventType, sourceObjectType, sourceObjectId, null);
    }

    /**
     * 创建事件并提交事件
     * @param eventType          事件类型
     * @param sourceObjectType  事件源对象类型
     * @param sourceObjectId    事件源对象ID
     * @param attachmentData    事件的附加数据
     */
    public void createAndPost(String eventType, String sourceObjectType, String sourceObjectId, Object attachmentData) {
        post(createEvent(eventType, sourceObjectType, sourceObjectId, attachmentData));
    }

    protected abstract TransactionEvent createEvent(String eventType, String sourceObjectType, String sourceObjectId, Object attachmentData);

    protected void post(TransactionEvent event) {
        String eventType = event.getType();
        Set<EventHandler> handlerSet = getEventHandlers(eventType);
        if(handlerSet == null) {
            logger.warn("[" + eventType + "]类型的事件没有对应的事件处理器，将此事件丢弃掉。");
        } else {
            EventRunnable asyncEvent = createAsyncEvent(event, handlerSet);
            taskDispatcher.putAsyncTask(asyncEvent);
            if(logger.isDebugEnabled()) {
                logger.debug("事件[" + eventType + "]已被放入异步处理中！");
            }
        }
    }

    protected Set<EventHandler> getEventHandlers(String eventType) {
        Set<EventHandler> eventHandlerSet = eventHandlerMap.get(eventType);
        if(eventHandlerSet == null) {
            throw new HandlerNotFoundException("未找到[" + eventType + "]对应的EventHandler.");
        }
        return eventHandlerSet;
    }

    /**
     * 生成异步执行的事件，这里仅提供最为简单的方式，未进行持久化，为了保证在发生系统异常之后仍然可以
     * @param event
     * @param eventHandlerSet
     * @return
     */
    protected EventRunnable createAsyncEvent(TransactionEvent event, Set<EventHandler> eventHandlerSet) {
        return new EventRunnable(event, eventHandlerSet);
    }

}
