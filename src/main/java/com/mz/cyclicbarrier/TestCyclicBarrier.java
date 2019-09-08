package com.mz.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {
    private static final Integer NUM=6;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(NUM,()->{
            System.out.println("CyclicBarrier - > 执行！");
        });

        /**
         * 线程到达一个同步点 被阻塞
         * 最后一个线程达到屏障后被执行
         */
        for (int i=0;i<NUM;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t");
                try {
                    //进入屏障
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
