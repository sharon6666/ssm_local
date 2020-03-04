package com.leetcode;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.leetcode
 * @Description: note
 * @Author:
 * @date: 2019-11-22 11:16
 * @UpdateUser:
 * @UpdateDate: 2019-11-22 11:16
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class FindMin {
    public static BinaryNode findMinMethod(BinaryNode t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMinMethod(t.left);
    }
    public static void main(String[] args){
//        findMinMethod();
    }
}
