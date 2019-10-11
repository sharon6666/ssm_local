package com.practiceThread.TwoThread;


/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.practiceThread.TwoThread
 * @Description: note
 * @Author:
 * @CreateDate: 2019-9-9 10:25
 * @UpdateUser:
 * @UpdateDate: 2019-9-9 10:25
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class AddRunnable implements Runnable {

    MyData myData;

    public AddRunnable(MyData myData){
        this.myData = myData;
    }

    @Override
    public void run() {
        myData.add();
    }

    public static void main(String[] args) {
        MyData data = new MyData();
        Runnable add = new AddRunnable(data);
        Runnable dec = new DecRunnable(data);
        for (int i = 0; i < 2; i++) {
            new Thread(add).start();
            new Thread(dec).start();
        }
    }
}

