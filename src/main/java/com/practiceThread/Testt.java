package com.practiceThread;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.practiceThread
 * @Description: note
 * @Author:
 * @CreateDate: 2019-10-14 11:00
 * @UpdateUser:
 * @UpdateDate: 2019-10-14 11:00
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Testt {
        static Testt t=new Testt();

        class T1 extends Thread{
            @Override
            public void run() {

                //T1线程中要处理的东西
                System.out.println("T1线程执行");
                for(int i=0;i<10;i++){
                    System.out.println(this.getName() + ":" + i);
                }

            }

        }

        class T2 extends Thread{

            @Override
            public void run() {

                //T2线程中要处理的东西
                System.out.println("T2线程执行");

                for(int i=0;i<10;i++){
                    System.out.println(this.getName() + ":" + i);
                }


            }

        }

        class T3 extends Thread{

            @Override
            public void run() {

                //T3线程中要处理的东西
                System.out.println("T3线程执行");

                for(int i=0;i<10;i++){
                    System.out.println(this.getName() + ":" + i);
                }


            }


        }


        public static void main(String[] args) {


            try {
                t.new T3().start();//启动t3线程
                t.new T3().join();//阻塞主线程，执行完t3再返回
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            try {
                t.new T2().start();//启动t2线程
                t.new T2().join();//阻塞主线程，执行完t2再返回
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            try {
                t.new T1().start();//启动t1线程
                t.new T1().join();//阻塞主线程，执行完t1再返回
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }




        }

}
