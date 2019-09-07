package com.mz.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class TextCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         *  启动后台线程 执行一个不阻塞 当前主线程的任务 ,用于复杂的计算 并且获取结果
         *  如果对一个FutureTask 启动多个线程来执行的话,只会返还一次结果，不会经过重复调用
         *  Get 方法一般都是放在 最后执行，因为Get方法调用的时候 会阻塞主线程
         *
         *  Callable接口和Runnable的区别是
         *  Callable 支持泛型  支持返回值
         *  调用只计算一次
         *
         *
         */

        FutureTask<String> futureTask = new FutureTask(() -> {
            TimeUnit.SECONDS.sleep(1);
            return "你好";
        });
        new Thread(futureTask,"BB").start();
        System.out.println("主线程结束");
        String s = futureTask.get();
        System.out.println("返还值\t"+s);
    }
}
