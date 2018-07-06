package com.testssm.event;

/**
 * 事件处理器，注意：所有事件的处理必须要做到幂等性，即：不管重复执行多少次都必须结果相同！
 */
public interface EventHandler {
    /**
     * 监听的事件类型
     */
    String[] listenEventTypes();

    /**
     * 处理事件
     * @param event
     */
    void handleEvent(TransactionEvent event);

}
