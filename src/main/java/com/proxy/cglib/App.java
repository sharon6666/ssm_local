package com.proxy.cglib;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.proxy.cglib
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-22 11:25
 * @UpdateUser:
 * @UpdateDate: 2019-7-22 11:25
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class App {
    public static void main(String[] args){
        UserDao userDao = new UserDao();
        UserDao proxy = (UserDao)new ProxyFactory(userDao).getTargetInstance();
        proxy.save();
    }
}
