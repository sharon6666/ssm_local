package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.leetcode
 * @Description: note
 * @Author:
 * @date: 2019-11-20 17:00
 * @UpdateUser:
 * @UpdateDate: 2019-11-20 17:00
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class TreeDepth {
    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int res = Math.max(left, right) + 1;
        return res;
        /*if (root == null)
            return 0;

        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            ++res;
            for (int i = q.size(); i > 0; --i) {
                TreeNode t = q.poll();
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
        }
        return res;*/
    }
    public static void main(String[] args){
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.left.left = null;
        node.left.right = null;
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        System.out.println(maxDepth(node));
    }

}
