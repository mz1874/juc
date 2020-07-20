package com.mz.single;

/**
 * @author: candy
 * @date: 2020/7/20
 * @description : 饿汉式单例
 * 一般使用的时候 不要纠结是饿汉式或者懒汉式
 * 既然已经加载了 肯定是需要使用的 不然加载它干嘛
 **/
public class single2 {

    private static volatile single2 s;

    private single2() {
    }

    public static single2 getInstance() {
        if (s == null) {
            synchronized (single2.class) {
                if (s == null) {
                    try {
                        Thread.sleep(1);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    s = new single2();
                }
            }
        }
        return s;
    }




}
