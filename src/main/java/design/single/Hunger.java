package design.single;

import javafx.collections.ArrayChangeListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述
 * 饿汉式单例模式  饿汉式天生线程安全，类加载的时候初始化一次对象，效率比懒汉式高。
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: design.single
 * @Description: note
 * @Author:
 * @date: 2019-10-29 16:21
 * @UpdateUser:
 * @UpdateDate: 2019-10-29 16:21
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Hunger {
    private static final Hunger hunger = new Hunger(); //准备的时候就已经加载好值了，一个类就一个

    private Hunger(){
        super();
    }

    public static Hunger getInstance(){
        return hunger;
    }

    public static void main(String[] args) {

        Hunger teacher1 = Hunger.getInstance();
        Hunger teacher2 = Hunger.getInstance();
        System.out.println(teacher1==teacher2);
    }
}
