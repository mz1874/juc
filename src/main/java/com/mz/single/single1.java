package com.mz.single;

/**
 * @author: candy
 * @date: 2020/7/20
 * @description : 饿汉式单例
 * 一般使用的时候 不要纠结是饿汉式或者懒汉式
 * 既然已经加载了 肯定是需要使用的 不然加载它干嘛
 **/
public class single1 {

    private static single1 s = new single1();

    private single1() {
    }

    public static single1 getInstance() {
        return s;
    }


}
