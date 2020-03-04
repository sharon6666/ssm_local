package com.proxy.jdk;

/**
 * @author wangrx23694
 * @date
 * @description
 */
public class Liu implements Star {

    @Override
    public String  sing() {
        System.out.println("我是刘星， 我会唱歌");
        return "唱歌";
    }

    @Override
    public String dance() {
        System.out.println("我是刘涛，我会跳舞");
        return "跳舞";
    }
}
