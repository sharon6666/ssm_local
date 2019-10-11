package com.javese.anno;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.javese.anno
 * @Description: note
 * @Author:
 * @CreateDate: 2019-8-21 13:35
 * @UpdateUser:
 * @UpdateDate: 2019-8-21 13:35
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class SubClass extends ParentClass {
    @Override
    public void abstractMethod(){
        System.out.println("子类覆盖父类方法abstractMethod");
    }

    @Override
    public void doHandle(){
        System.out.println("子类覆盖父类doHandel方法");
    }
}
