package com.javese.e;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.javese.e
 * @Description: note
 * @Author:
 * @CreateDate: 2019-8-14 16:33
 * @UpdateUser:
 * @UpdateDate: 2019-8-14 16:33
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Etest {
    public static <E> void printArray(E[] intArray){
        for(E e : intArray){
            System.out.printf("%s ",e);
        }
    }
}
