package com.javese.anno;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.javese.anno
 * @Description: note
 * @Author:
 * @CreateDate: 2019-8-21 13:34
 * @UpdateUser:
 * @UpdateDate: 2019-8-21 13:34
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
@MyAnnotation(value = "类名上的注解")
public abstract class ParentClass {

    @MyAnnotation(value = "父类的abstractMethod方法")
    public abstract void abstractMethod();

    @MyAnnotation(value = "父类的doExtends方法")
    public void doExtends() {
        System.out.println(" ParentClass doExtends ...");
    }

    @MyAnnotation(value = "父类的doHandle方法")
    public void doHandle(){
        System.out.println(" ParentClass doHandle ...");
    }
}
