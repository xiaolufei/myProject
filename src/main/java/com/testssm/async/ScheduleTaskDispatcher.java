package com.testssm.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleTaskDispatcher implements InitializingBean {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**最大的任务执行时间,默认为1分钟*/
    private long intervalCheckTimeMillis = 2 * 1000;

    private ScheduledExecutorService taskExecuteThreadPool;

    private ConcurrentLinkedQueue<ScheduleRunnable> executeQueue;

    protected int executeThreadSize = 2;

    public void setExecuteThreadSize(int executeThreadSize) {
        this.executeThreadSize = executeThreadSize;
    }

    public void putAsyncTask(ScheduleRunnable asyncTask) {
        executeQueue.add(asyncTask);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        taskExecuteThreadPool = Executors.newScheduledThreadPool(executeThreadSize);
        if(logger.isInfoEnabled()) {
            logger.info("The system has created [" + executeThreadSize + "] execute thread.");
        }
        executeQueue = new ConcurrentLinkedQueue<>();
        for(int i = 0; i < executeThreadSize; i ++) {
            taskExecuteThreadPool.scheduleWithFixedDelay(new Runnable() {
                @Override
                public void run() {
                    List<ScheduleRunnable> failRunnable = new ArrayList<>();
                    ScheduleRunnable model;
                    while ((model = executeQueue.poll()) != null) {
                        if (!model.run()) {
//                            executeQueue.add(model);
                            failRunnable.add(model);
                        }
                    }
                    for(ScheduleRunnable fail : failRunnable) {
                        executeQueue.add(fail);
                    }
                    if (logger.isTraceEnabled()) {
                        logger.trace("ScheduleTaskDispatcher本轮执行完成!");
                    }
                }
            }, 0, intervalCheckTimeMillis, TimeUnit.MILLISECONDS);
        }
    }
}
