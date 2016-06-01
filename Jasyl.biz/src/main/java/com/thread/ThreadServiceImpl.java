package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jason on 16/6/1.
 */
public class ThreadServiceImpl implements ThreadService{

    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public void execute(Runnable task) {

        executorService.execute(task);

    }
}
