package com.mz.threadpool;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThreadPool {
    public static void main(String[] args) {
        //固定的线程池
//        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //带缓存的线程池
//        ExecutorService executorService=Executors.newCachedThreadPool();

        //单个线程
//        ExecutorService executorService=Executors.newSingleThreadExecutor();

        //

          ScheduledExecutorService executorService=Executors.newScheduledThreadPool(5);
          executorService.scheduleWithFixedDelay(()->{
              System.out.println(Thread.currentThread().getName()+"\t你好");
          },0,1,TimeUnit.MICROSECONDS);



//        Future<Integer> submit=null;
//        try {
//            for (int i = 0; i < 15; i++) {
//                submit = executorService.submit(() -> {
//                    System.out.print(Thread.currentThread().getName()+"\t");
//                    return new Random().nextInt(10);
//                });
//            System.out.println("*******************"+submit.get());
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }finally {
//            executorService.shutdown();
//        }
    }
}
