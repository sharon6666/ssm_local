package com.leetcode;

import javafx.scene.AmbientLight;

import java.util.*;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.leetcode
 * @Description: note
 * @Author:
 * @date: 2019-11-19 14:03
 * @UpdateUser:
 * @UpdateDate: 2019-11-19 14:03
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class BinaryTree {
    // 先序遍历 递归
    public static void firstErgodic(TreeNode treeNode){
        if(treeNode == null)
            return;
        System.out.printf(treeNode.value + "->");
        BinaryTree.firstErgodic(treeNode.left);
        BinaryTree.firstErgodic(treeNode.right);
    }
    
    public static void firstErgodic1(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(treeNode != null || !stack.isEmpty())
        {
            while(treeNode != null)
            {
                System.out.printf(treeNode.value + "->");
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if(!stack.isEmpty())
            {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    // 中序遍历 递归
    public static void mediumErgodic(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        BinaryTree.mediumErgodic(treeNode.left);
        System.out.printf(treeNode.value + "->");
        BinaryTree.mediumErgodic(treeNode.right);
    }

    public static void mediumErgodic1(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (treeNode != null || !stack.empty()){
            while (treeNode != null){
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if(!stack.empty()){
                treeNode = stack.pop();
                System.out.printf(treeNode.value + "->");
                treeNode = treeNode.right;
            }
        }
    }

    // 后序递归
    public static void lastErgodic(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        // 先左后右最后中间
        BinaryTree.lastErgodic(treeNode.left);
        BinaryTree.lastErgodic(treeNode.right);
        System.out.printf(treeNode.value + "->");
    }

    // 后续非递归
    public static void lastErgodic1(TreeNode treeNode){
        int left = 1;//在辅助栈里表示左节点
        int right = 2;//在辅助栈里表示右节点
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> stack2 = new Stack<Integer>();//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点。

        while (treeNode != null || !stack.empty()){
            while (treeNode != null){
                stack.push(treeNode);
                stack2.push(left);
                treeNode = treeNode.left;
            }
            while (!stack.empty() && stack2.peek() == right){
                stack2.pop();
                System.out.printf(stack.pop().value + "->");
            }
            if(!stack.empty() && stack2.peek() == left){
                //如果是从左子节点返回父节点，则将标记改为右子节点
                stack2.pop();
                stack2.push(right);
                treeNode = stack.peek().right;
            }
        }
    }

    /**
     * 按层排序
     * @param root
     */
    public static void orderByStair(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp;
        while (!queue.isEmpty()){
            temp = queue.poll();
            System.out.printf(temp.value + "->");
            if(null != temp.left){
                queue.offer(temp.left);
            }
            if(null != temp.right){
                queue.offer(temp.right);
            }
        }
    }

    public static void main(String[] args){
        TreeNode[] arr = new TreeNode[10];
        for(int i=0;i<arr.length;i++){
            arr[i] = new TreeNode(i);
        }
        // 分配treeNode的左右子树
        /**
         *             0
         *        1          2
         *     3     4    5     6
         *   7  8  9
         */

        for(int i=0;i<5;i++){
            if(i*2+1 < 10){
                arr[i].left = arr[i*2+1];
            }
            if(i*2+2<10){
                arr[i].right = arr[i*2+2];
            }
        }

        System.out.println("后序");
        lastErgodic(arr[0]);
        System.out.println();
        lastErgodic1(arr[0]);
        System.out.println();

        System.out.println("中序");
        mediumErgodic(arr[0]);
        System.out.println();
        mediumErgodic1(arr[0]);
        System.out.println();

        System.out.println("前序");
        firstErgodic(arr[0]);
        System.out.println();
        firstErgodic1(arr[0]);

        System.out.println();
        System.out.println("按层排序");
        orderByStair(arr[0]);


        System.out.println( Math.max(11,11));
    }

    private static class BinaryNode<AnyType>{
        AnyType element;
        BinaryNode left;
        BinaryNode right;
        BinaryNode(AnyType theElement){
            this(theElement, null, null);
        }

        BinaryNode(AnyType theElement, BinaryNode l1, BinaryNode r1){
            element = theElement;
            l1 = left;
            r1 = right;
        }
    }
}

class BinaryNode{
 Object element;
 BinaryNode left;
 BinaryNode right;
}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value){
        this.value = value;
    }
}
