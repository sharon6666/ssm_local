package com.practiceThread.TwoThread;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.practiceThread.TwoThread
 * @Description: note
 * @Author:
 * @CreateDate: 2019-9-9 10:28
 * @UpdateUser:
 * @UpdateDate: 2019-9-9 10:28
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class DecRunnable implements Runnable {
    MyData data;

    public DecRunnable(MyData data) {
        this.data = data;
    }

    public void run() {
        data.desc();
    }

    public static void main(String[] args) {
        final MyData data = new MyData();
        for(int i=0;i<2;i++){
            new Thread(new Runnable(){
                public void run() {
                    data.add();
                }
            }).start();
            new Thread(new Runnable(){
                public void run() {
                    data.desc();
                }
            }).start();
        } }
}
