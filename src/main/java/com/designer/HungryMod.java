package com.designer;

import java.rmi.MarshalledObject;

/**
 * @author wangrx23694
 * @date
 * @description
 */
public class HungryMod {
    // 饿汉式 实例化对象
    private static final HungryMod mod = new HungryMod();

    private static HungryMod getInstance(){
        return mod;
    }

    // 在静态代码块中
    private static HungryMod hungryMod;

    static {
        hungryMod = new HungryMod();
    }

    public static HungryMod getNewInstance(){
        return hungryMod;
    }

}
