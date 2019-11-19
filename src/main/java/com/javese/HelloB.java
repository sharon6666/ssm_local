package com.javese;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.javese
 * @Description: note
 * @Author:
 * @date: 2019-11-11 11:32
 * @UpdateUser:
 * @UpdateDate: 2019-11-11 11:32
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class HelloB {
    int i = 1;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HelloB() {
//        Thread thread = new Thread() {
//            public void run() {
//                for (int j=0;j<20;j++) {
//                    HelloB.this.run();//调用外部类的方法  因为两个方法名字一致，所以为了调用外面的方法，又不改变名字的情况下，用this来调用
//                    try {
//                        sleep(1000);
//                    } catch (InterruptedException ie) {
//                    }
//                }
//            }
//        }; // 注意这里有分号
//        thread.start();
    }

    public void run() {
        System.out.println("i = " + i);
        i++;
    }

    public static void call(HelloB t) {
        HelloB t2 = new HelloB();
        t2.setName("cba");
        t.setName("abc");
        t = t2 ;
    }

    public static void main(String[] args) throws Exception {
//        new HelloB();

//        HelloB p = new HelloB();
//        p.x = 9;
//        p.y = 10;
//        p.seeit();

        HelloB obj = new HelloB();
        call (obj) ;
        System.out.println("obj: "+obj.getName());
    }

    int x;
    int y;

    static void showtest(HelloB tc) {//实例化对象
        System.out.println(tc.x + " " + tc.y);
    }
    void seeit() {
        showtest(this);//相当于传了一个对象进来
    }

}