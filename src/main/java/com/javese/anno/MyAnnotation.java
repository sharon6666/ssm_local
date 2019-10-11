package com.javese.anno;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.javese.anno
 * @Description: note
 * @Author:
 * @CreateDate: 2019-8-21 13:32
 * @UpdateUser:
 * @UpdateDate: 2019-8-21 13:32
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value();
}
