package com.proxy.factory;

import com.proxy.staticModel.IUserDAO;
import com.proxy.staticModel.UserDAO;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.proxy.factory
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-22 10:56
 * @UpdateUser:
 * @UpdateDate: 2019-7-22 10:56
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class App {
    public static void main(String[] args){
        //目标对象
        IUserDAO userDAO = new UserDAO();
        System.out.println(userDAO.getClass());

        //给目标对象创建代理对象
        IUserDAO userDAO1 = (IUserDAO) new ProxyFactory(userDAO).getProxyInstance();
        System.out.println(userDAO1.getClass());
        userDAO1.save();
    }
}
