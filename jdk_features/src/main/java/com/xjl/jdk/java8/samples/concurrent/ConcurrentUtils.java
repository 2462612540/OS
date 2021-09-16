package com.xjl.jdk.java8.samples.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @description TODO
 * @param: null
 * @date: 2021/9/16 23:37
 * @return:
 * @author: xjl
 */
public class ConcurrentUtils {

    public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
