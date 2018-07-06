package com.testssm.async;


import com.testssm.event.EventWarner;
import com.testssm.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 用Callable实现的AsyncTaskDispatcher,这里是改进BlockingQueueDispatcher中无法监控执行时间过长的任务的问题!
 */
public class CallableFutureDispatcher extends AsyncTaskDispatcher {
    /**最大的任务执行时间,默认为1分钟*/
    private long maxTaskRunningTimeMillis = 60 * 1000;
    private long intervalCheckTimeMillis = 60 * 1000;
    @Autowired
    private EventWarner eventWarner;
    @Autowired
    private ScheduleTaskDispatcher scheduleTaskDispatcher;

    private Map<ExecuteDispatcher, Future<Boolean>> executeMap;

    private ExecutorService taskExecuteThreadPool;

    public void setMaxTaskRunningTimeMillis(long maxTaskRunningTimeMillis) {
        this.maxTaskRunningTimeMillis = maxTaskRunningTimeMillis;
    }

    public void setIntervalCheckTimeMillis(long intervalCheckTimeMillis) {
        this.intervalCheckTimeMillis = intervalCheckTimeMillis;
    }

    @Override
    public void putAsyncTask(Runnable asyncTask) {
        if(logger.isTraceEnabled()) {
            logger.trace("异步任务添加成功,其添加位置是:\n" + ExceptionUtils.getCallStackTraceByException(new Exception(), 3));
        }
        ExecuteDispatcher executeDispatcher = new ExecuteDispatcher(asyncTask);
        try {
            executeMap.put(executeDispatcher, taskExecuteThreadPool.submit(executeDispatcher));
        } catch (Exception e) {
            logger.error("严重错误:异步任务添加失败,其添加位置是:\n" + ExceptionUtils.getCallStackTraceByException(new Exception(), 3), e);
            eventWarner.sendWarn(EventWarner.Type.SYSTEM, EventWarner.Level.MODULE_PART_UNAVAILABLE, "严重错误", "严重错误:异步任务" +asyncTask.getClass().getName()+ "添加失败!");
        }
        if(executeMap.size() > 15) {
            String warnMessage = "异步处理的BlockingQueue中已有" + executeMap.size() + "个待处理的任务!";
            logger.warn(warnMessage);
            eventWarner.sendWarn(EventWarner.Type.SYSTEM, EventWarner.Level.AVAILABILITY_WARN, "异步任务警告", warnMessage);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        taskExecuteThreadPool = Executors.newFixedThreadPool(executeThreadSize);
        if(logger.isInfoEnabled()) {
            logger.info("The system has created [" + executeThreadSize + "] execute thread.");
        }
        executeMap = new ConcurrentHashMap<>();
        ScheduleRunnable cleanRunnable = new ScheduleRunnable(new ScheduleRunnable.ScheduleTask() {
            @Override
            public boolean run() {
                if(!executeMap.isEmpty()) {

                    if(logger.isDebugEnabled()) {
                        logger.debug("定时任务检查:有{}个正在执行/待执行的任务待检查!", executeMap.size());
                    }
                    for(ExecuteDispatcher runningTask: executeMap.keySet()) {
                        if(runningTask.getTaskStartTime() > 0) {
                            long runningTime = System.currentTimeMillis() - runningTask.getTaskStartTime();
                            if(runningTime > maxTaskRunningTimeMillis) {
                                Future<Boolean> future = executeMap.get(runningTask);
                                if(future == null) {
                                    if(logger.isInfoEnabled()) {
                                        logger.info("定时任务检查:无法从executeMap中获得Future,可能是由于并发原因此任务已经正常结束!");
                                    }
                                } else {
                                    future.cancel(true);
                                    logger.warn("定时任务检查:任务{}已经执行{}ms,已超出最大执行时间{}ms,因此将其强项终止!", runningTask.getAsyncTask(), runningTime, maxTaskRunningTimeMillis);
                                    executeMap.remove(runningTask);
                                }
                            }
                        }
                    }
                } else {
                    if(logger.isDebugEnabled()) {
                        logger.debug("定时任务检查:无正在执行的异步任务!");
                    }
                }
                return false;
            }
        }, -1, intervalCheckTimeMillis);
        scheduleTaskDispatcher.putAsyncTask(cleanRunnable);
    }

    public final class ExecuteDispatcher implements Callable<Boolean> {

        private long taskStartTime;

        private Runnable asyncTask;

        public ExecuteDispatcher(Runnable asyncTask) {
            this.asyncTask = asyncTask;
        }

        @Override
        public Boolean call() throws Exception {
            if(logger.isDebugEnabled()) {
                logger.debug("ExecuteDispatcher启动!");
            }
            if(asyncTask != null) {
                if(logger.isTraceEnabled()) {
                    logger.trace("成功获取任务({}),开始执行任务!", asyncTask);
                }
                taskStartTime = System.currentTimeMillis();
                try {
                    asyncTask.run();
                } catch (Exception e) {
                    logger.error("[警告]任务{}执行发生异常！异常信息：{}", asyncTask.getClass().getName(), e.getMessage());
                    logger.error(e.getMessage(), e);
                } finally {
                    executeMap.remove(this);
                }
                long usedTime = System.currentTimeMillis() - taskStartTime;
                if(usedTime > 3 * 1000) { //如果任务执行操作3秒,那么就需要记录警告
                    logger.warn("[警告]任务{}执行共耗时{}ms,耗时较长请优化!", asyncTask.getClass().getName(), usedTime);
                }
            } else {
                logger.error("asyncTask is null!");
            }
            if(logger.isDebugEnabled()) {
                logger.debug("ExecuteDispatcher完成!");
            }
            return Boolean.TRUE;
        }

        public long getTaskStartTime() {
            return taskStartTime;
        }

        public Runnable getAsyncTask() {
            return asyncTask;
        }
    }
}
