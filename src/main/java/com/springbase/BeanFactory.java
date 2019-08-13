package com.springbase;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.springbase
 * @Description: note
 * @Author:
 * @CreateDate: 2019-8-7 11:33
 * @UpdateUser:
 * @UpdateDate: 2019-8-7 11:33
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public interface BeanFactory {

    Object getBean(String name) throws Exception;
}
