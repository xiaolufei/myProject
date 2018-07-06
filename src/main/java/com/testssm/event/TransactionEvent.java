package com.testssm.event;

/**
 * 交易事件
 */
public interface TransactionEvent {
    /**
     * 消息ID
     */
    String getId();
    /**
     * 得到事件类型
     */
    String getType();

    /**
     * 事件源的类型
     */
    String getSourceType();

    /**
     * 事件源的对象ID
     */
    String getSourceObjectId();

    /**
     * 得到附加的数据
     */
    <T> T getAttachmentData(Class<T> dataClass);

}