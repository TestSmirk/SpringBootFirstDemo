package com.testsmirk.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class TaskQueue {
    private BlockingQueue<ITask> mTaskQueue;
    private TaskExecutor[] mTaskExecutors;

    public TaskQueue(int size) {
        mTaskExecutors = new TaskExecutor[size];
        mTaskQueue = new LinkedBlockingDeque<>();

    }

    public void start() {

        stop();
        for (int i = 0; i < mTaskExecutors.length; i++) {
            mTaskExecutors[i]  = new TaskExecutor(mTaskQueue);
            mTaskExecutors[i].start();
        }
    }

    public void stop() {
        if (mTaskExecutors != null) {
            for (TaskExecutor mTaskExecutor : mTaskExecutors) {
                if (mTaskExecutor == null) {
                    continue;
                }
                mTaskExecutor.quit();
            }
        }
    }

    public <T extends ITask> int add (T task){
        if (!mTaskQueue.contains(task)) {
            mTaskQueue.add(task);
        }
        return mTaskQueue.size();
    }
}
