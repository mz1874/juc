package com.mz.copyonwrite;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestArray {

    /**
     * @apiNote
     * @deprecated 不赞成的
     * @throws ConcurrentModificationException
     */
    public static void list(){
        List<String> list=new CopyOnWriteArrayList<>();
        for (int i = 0; i <100 ; i++) {
            int finalI = i;
            new Thread(()->{
            list.add(String.valueOf(finalI));
            System.out.println(Thread.currentThread().getName()+"\t"+list);
            },String.valueOf(i)).start();
        }
    }

    public static void main(String[] args) {
        list();
    }
}
