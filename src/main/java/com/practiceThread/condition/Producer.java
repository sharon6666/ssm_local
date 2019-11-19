package com.practiceThread.condition;

import com.practiceThread.thread.Run;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.practiceThread.condition
 * @Description: note
 * @Author:
 * @date: 2019-11-6 16:30
 * @UpdateUser:
 * @UpdateDate: 2019-11-6 16:30
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Producer implements Runnable {
    private ProductPro productPro;

    public Producer(ProductPro productPro){
        this.productPro = productPro;
    }

    @Override
    public void run(){
        for(int i=0;i<10;i++){
            if(productPro != null)
            productPro.pop();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
