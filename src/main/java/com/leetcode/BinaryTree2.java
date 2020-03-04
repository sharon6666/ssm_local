package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.leetcode
 * @Description: note
 * @Author:
 * @date: 2019-11-20 16:00
 * @UpdateUser:
 * @UpdateDate: 2019-11-20 16:00
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class BinaryTree2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode t;
        while(!q.isEmpty()){
            list = new ArrayList();
            int count = q.size();
            while(count > 0){
                t = q.poll();
                if(result.size() % 2 == 0){
                    list.add(t.value);
                }else{
                    list.add(0,t.value);
                }
                if(t.left != null){
                    q.add(t.left);
                }
                if(t.right != null){
                    q.add(t.right);
                }
                count--;
            }
            result.add(list);
        }
        return result;
    }
}
