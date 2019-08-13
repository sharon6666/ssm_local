package com.proxy.staticModel;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.proxy.staticModel
 * @Description: note
 * @Author:
 * @CreateDate: 2019-7-22 9:48
 * @UpdateUser:
 * @UpdateDate: 2019-7-22 9:48
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 * 目标对象
 **/
public class UserDAO implements IUserDAO {
    public void save(){
        System.out.println("--已成功保存数据！");
    }
}
