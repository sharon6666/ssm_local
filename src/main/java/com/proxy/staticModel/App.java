package com.proxy.staticModel;


import com.proxy.staticModel.UserDAO;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.proxy.staticModel
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-22 10:22
 * @UpdateUser:
 * @UpdateDate: 2019-7-22 10:22
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class App {
    public static void main(String[] args){
        UserDAO userDao = new UserDAO();
        UserDaoProxy proxy = new UserDaoProxy(userDao);
        proxy.save();
    }
}
