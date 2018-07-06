package com.testssm.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定时执行的
 */
public class ScheduleRunnable {
    private static Logger logger = LoggerFactory.getLogger(ScheduleRunnable.class);

    private ScheduleTask asyncTask;

    private String taskName;

    private long expiredTime;

    private long initialTime;

    private long nextStartTime;

    private long intervalRunTimeMillis;

    public ScheduleRunnable(ScheduleTask task, long liveTimeMillis, long intervalRunTimeMillis) {
        this.asyncTask = task;
        this.taskName = task.getClass().getName();
        this.initialTime = System.currentTimeMillis();
        if(liveTimeMillis < 0) {
            this.expiredTime = Long.MAX_VALUE;
        } else {
            this.expiredTime = initialTime + liveTimeMillis;
        }
        this.nextStartTime = initialTime;
        this.intervalRunTimeMillis = intervalRunTimeMillis;
    }

    public boolean run() {
        long now = System.currentTimeMillis();
        if(expiredTime > now) {
            if(now >= nextStartTime) {
                if(asyncTask.run()) {
                    if(logger.isInfoEnabled()) {
                        logger.info("任务({})已经执行成功，不再使用定时任务进行执行！", taskName);
                    }
                    return true;
                } else {
                    if(logger.isDebugEnabled()) {
                        logger.debug("任务({})还需继续执行！", taskName);
                    }
                    nextStartTime += intervalRunTimeMillis;
                    return false;
                }
            } else {
                if(logger.isTraceEnabled())
                    logger.trace("任务({})还未到预定的执行时间，暂不执行！", taskName);
                return false;
            }
        } else {
            if(logger.isInfoEnabled())
                logger.info("任务({})已经超过预定时间，不再使用定时任务进行执行！", taskName);
            return true;
        }
    }



    public interface ScheduleTask {

        /**
         * 执行任务，如果任务需要继续执行，那么返回false，如果任务不需要继续执行，那么返回true
         * @return　是否执行完成，如果执行完成，那么任务就结束了。
         */
        boolean run();

    }
}
