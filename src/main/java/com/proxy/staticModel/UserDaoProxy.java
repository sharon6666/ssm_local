package com.proxy.staticModel;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.proxy.staticModel
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-22 9:58
 * @UpdateUser:
 * @UpdateDate: 2019-7-22 9:58
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class UserDaoProxy implements IUserDAO{
    private IUserDAO userDAO;

    public UserDaoProxy(IUserDAO userDAO){
        this.userDAO = userDAO;
    }
    @Override
    public void save() {
        System.out.println("开始改造");
        System.out.println("改造后得save方法，实现了调用目标对象但是调用自己实现得方法");
    }
}
