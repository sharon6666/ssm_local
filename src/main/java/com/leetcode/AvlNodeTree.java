package com.leetcode;

/**
 * 文件描述
 *  查找二叉树 初始化
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.leetcode
 * @Description: note
 * @Author:
 * @date: 2019-11-22 14:12
 * @UpdateUser:
 * @UpdateDate: 2019-11-22 14:12
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class AvlNodeTree {
    private static class AvlNode<AnyType>{
        AnyType element;
        AvlNode<AnyType> left;
        AvlNode<AnyType> right;
        int height = 0;

        AvlNode(AnyType theElement){
            this(theElement, null, null);
        }

        AvlNode(AnyType theElement, AvlNode<AnyType> lt, AvlNode<AnyType> rt){
            element = theElement;
            lt = left;
            rt = right;
            height = 0;
        }
    }
    private int height(AvlNode t){
        return t == null ? -1:t.height;
    }
}
