package com.practiceThread.condition;

import com.practiceThread.thread.C;
import org.springframework.cache.annotation.CachingConfigurerSupport;

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
public class Consumer implements Runnable{

    public ProductPro productPro;

    public Consumer(ProductPro productPro){
        this.productPro = productPro;
    }

    @Override
    public void run(){
        for(int i=0;i<10;i++){
            Cat cat  = new Cat(i);
            if (productPro != null)
            productPro.push(cat);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
