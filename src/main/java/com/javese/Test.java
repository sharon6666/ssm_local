package com.javese;

/**
 * @author wangrx23694
 * @date
 * @description
 */
public abstract class Test {
    public void print(){
        System.out.println("lalala");
    }
    public int age;
}

class App extends Test{
    @Override
    public void print(){
        System.out.println("this is app");
    }
}