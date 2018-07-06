package com.testssm.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * 异步任务调度器
 */
public abstract class AsyncTaskDispatcher implements InitializingBean {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected int executeThreadSize = 20;

    public void setExecuteThreadSize(int executeThreadSize) {
        this.executeThreadSize = executeThreadSize;
    }

    public abstract void putAsyncTask(Runnable asyncTask);

}
