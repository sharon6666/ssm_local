package com.practiceThread.condition;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.practiceThread.condition
 * @Description: note
 * @Author:
 * @date: 2019-11-6 16:33
 * @UpdateUser:
 * @UpdateDate: 2019-11-6 16:33
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Cat {

    public Cat(){
        this("ffff");
    }

    public Cat(String name){

    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cat(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                '}';
    }

    public static void main(String[] args){
        /*ProductPro productPro = new ProductPro();
        Producer pp = new Producer(productPro);
        Consumer cc = new Consumer(productPro);

        Thread t1 = new Thread(pp);
        Thread t2 = new Thread(cc);
        t1.start();
        t2.start();*/
//        System.out.println(reverseInteger(123));

        char a = 'a';
        System.out.println((int)a);
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        maxDepth(treeNode);
    }

    public static int reverseInteger(int number) {
        // write your code here
        String str = number + "";
        int result = 0;
        for(int i=str.length()-1;i>=0;i--){
            int a = Integer.valueOf(str.split("")[i]);
            if(a > 0){
                if(i == 2){
                    result = a *100;
                }
                if(i == 1){
                    result = result + a*10;
                }if ( i== 0){
                    result = result + a;
                }
            }
        }
        return result;
    }

    public static int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }
        int depth = 1;
        while(root.left != null || root.right != null){
            if(root.left != null){
                depth++;
            }else if(root.right != null){
                depth++;
            }
        }
        return depth;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int sum = length1 + length2;
        int[] sums = new int[sum];//[1,2,4] [2,3,5,6]
        if(length2 > length1){
            sums = nums2;
            nums2 = nums1;
            nums1 = nums2;
            sums = new int[sum];
        }
        for(int i=0;i<length1;i++){//i=0 i=1 2,
            for(int j=0;j<length2 && j>sums.length-1;j++){//j=0 j=1
                if(nums1[i]<nums2[j]){
                    sums[i] = nums1[i];//1
                    break;
                }else if(nums1[i] == nums2[j]){
                    sums[i] = nums1[i];
                }else{
                    sums[i] = nums2[j];
                    break;
                }
            }
        }
        if(sum%2 == 0){
            return (sums[sum/2]+sums[sum/2+1])/2;
        }else{
            return sums[(sum+1)/2];
        }
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
     byte a=1;
 }
