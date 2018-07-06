package com.testssm.async;

import com.aitou.framework.common.exception.ExceptionUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 采用concurrent中提供的BlockingQueue来实现异步任务调度。
 */
public class BlockingQueueDispatcher extends AsyncTaskDispatcher {

    private BlockingQueue<Runnable> asyncTaskQueue;
    private int queueCapacity;

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    @Override
    public void putAsyncTask(Runnable asyncTask) {
        if(asyncTaskQueue.add(asyncTask)) {
            if(logger.isTraceEnabled()) {
                logger.trace("异步任务添加成功,其添加位置是:\n" + ExceptionUtils.getCallStackTraceByException(new Exception(), 3));
            }
        } else {
            logger.error("严重错误:异步任务添加失败,其添加位置是:\n" + ExceptionUtils.getCallStackTraceByException(new Exception(), 3));
        }
    }

    protected Runnable takeAsyncTask() {
        if(logger.isTraceEnabled()) {
            logger.trace("开始从队列中获取任务,等待队列");
        }
        try {
            return asyncTaskQueue.take();
        } catch (InterruptedException e){
            logger.warn("获取任务时被打断!",e);
        }
        if(logger.isTraceEnabled()) {
            logger.trace("本次未从队列中获取待执行异步任务");
        }
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(queueCapacity > 0) {
            asyncTaskQueue = new LinkedBlockingQueue<>(queueCapacity);
        } else {
            asyncTaskQueue = new LinkedBlockingQueue<>();
        }
        ExecutorService threadPool = Executors.newFixedThreadPool(executeThreadSize);
        for(int i=0; i<executeThreadSize; i++) {
            threadPool.execute(new ExecuteDispatcher());
        }
        if(logger.isInfoEnabled()) {
            logger.info("The system has created [" + executeThreadSize + "] execute thread.");
        }
    }

    public final class ExecuteDispatcher implements Runnable {
        @Override
        public void run() {
            if(logger.isInfoEnabled()) {
                logger.info("ExecuteDispatcher线程已启动!");
            }
            while(true) {
            	Runnable asyncTask = takeAsyncTask();
                if(asyncTask != null) {
                    if(logger.isTraceEnabled()) {
                        logger.trace("成功获取任务({}),开始执行任务!", asyncTask);
                    }
                	asyncTask.run();
                }
            }
        }
    }
}
