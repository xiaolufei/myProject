package com.testssm.async;//FIXME 暂时注释掉：由于目前还无需使用。
//package com.aitou.framework.common.async;
//
//import com.lmax.disruptor.*;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class DistruptorDispatcher extends AsyncTaskDispatcher{
//    //缓冲区内的数据--队列长度
//    private int bufferSize = 2;
//
//    public int getBufferSize() {
//        return bufferSize;
//    }
//    public void setBufferSize(int bufferSize) {
//        this.bufferSize = bufferSize;
//    }
//
//    //ringBuffer---环形队列
//    /**
//     * WaitStrategy
//     当消费者等待在SequenceBarrier上时，有许多可选的等待策略，不同的等待策略在延迟和CPU资源的占用上有所不同，可以视应用场景选择：
//     BusySpinWaitStrategy ： 自旋等待，类似Linux Kernel使用的自旋锁。低延迟但同时对CPU资源的占用也多。
//     BlockingWaitStrategy ： 使用锁和条件变量。CPU资源的占用少，延迟大。
//     SleepingWaitStrategy ： 在多次循环尝试不成功后，选择让出CPU，等待下次调度，多次调度后仍不成功，尝试前睡眠一个纳秒级别的时间再尝试。这种策略平衡了延迟和CPU资源占用，但延迟不均匀。
//     YieldingWaitStrategy ： 在多次循环尝试不成功后，选择让出CPU，等待下次调。平衡了延迟和CPU资源占用，但延迟也比较均匀。
//     PhasedBackoffWaitStrategy ： 上面多种策略的综合，CPU资源的占用少，延迟大。
//     */
//    private RingBuffer<Runnable> ringBuffer = RingBuffer.createMultiProducer(new EventFactory<Runnable>() {
//        @Override
//        public AsyncTask newInstance() {
//            return new AsyncTask();
//        }
//    }, bufferSize, new BusySpinWaitStrategy());
//
//    //辅助工具
//    //workerPool --消费者工作池，用于获取对应消费数据
//    private WorkerPool<AsyncTask> workerPool = null;
//    private ExecutorService threadPool = null;
//
//    public WorkerPool<AsyncTask> getWorkerPool() {
//        return workerPool;
//    }
//
//    public ExecutorService getThreadPool() {
//        return threadPool;
//    }
//
//    @Override
//    public void putAsyncTask(AsyncTask asyncTask) {
//        long seq=ringBuffer.next();
//        AsyncTask data = ringBuffer.get(seq);
//        data.setData(asyncTask.getData());
//        data.setTaskName(asyncTask.getTaskName());
//        ringBuffer.publish(seq);
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        WorkHandler[] workHandlers = new WorkHandler[executeThreadSize];
//        for(int i=0;i<executeThreadSize;i++) {
//            WorkHandler<AsyncTask> workHandler = new ControlWorkHander();
//            workHandlers[i] = workHandler;
//        }
//        this.workerPool = new WorkerPool<AsyncTask>(ringBuffer, ringBuffer.newBarrier(), new IgnoreExceptionHandler(),workHandlers);
//        ringBuffer.addGatingSequences(workerPool.getWorkerSequences());
//        //提供对应线程池
//        threadPool = Executors.newFixedThreadPool(executeThreadSize);
//        logger.info("ringBuffer创建完毕，长度["+getBufferSize()+"]应为2的N次方,使用线程池大小["+executeThreadSize+"]");
//        this.workerPool.start(threadPool);
//        logger.info("distruptor 启动完毕，等待任务!");
//    }
//
//    /**
//     * 通用总控处理
//     */
//    private class ControlWorkHander implements WorkHandler<AsyncTask>{
//        @Override
//        public void onEvent(AsyncTask asyncTask) throws Exception {
//            String taskName = asyncTask.getTaskName();
//            AsyncTaskExecutor executor = executorMap.get(taskName);
//            if (logger.isDebugEnabled()) {
//                logger.debug("The  [" + taskName + "]'s mapping AsyncTaskExecutor is [" + executor.getClass().getName() + "].");
//            }
//            executor.execute(asyncTask);
//            if (logger.isDebugEnabled()) {
//                logger.debug("The  [" + taskName + "] has finished.");
//            }
//        }
//    }
//}
