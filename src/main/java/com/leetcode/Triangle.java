package com.leetcode;

import sun.nio.cs.ext.MacArabic;

import java.util.*;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.leetcode
 * @Description: note
 * @Author:
 * @date: 2019-11-25 14:16
 * @UpdateUser:
 * @UpdateDate: 2019-11-25 14:16
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Triangle {
    /**
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows == 0){
            return list;
        }
        List<Integer> list1;
        for(int i=1;i<=numRows;i++){//3
            list1 = new ArrayList<>();
            for (int j=1;j<=i;j++) {//123
                if (j == 1 || i == j) {
                    list1.add(1);
                } else {
                    list1.add(list.get(i-2).get(j-2) + list.get(i-2).get(j-1));
                }
            }
            list.add(list1);
        }
        return list;
    }

    public static void main(String []args){
//        System.out.println(generate(5));
        int[]a = {8,8,7,7,7};
        System.out.println(majorityElement(a));
    }

    /**
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     *
     * 示例 1:
     *
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/majority-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            if(!map.containsKey(nums[i])){
//                map.put(nums[i], 1);
//            }
//            map.put(nums[i], map.get(nums[i])+1);
//        }
//
//        Map.Entry<Integer, Integer> temp = null;
//        for(Map.Entry<Integer, Integer> m : map.entrySet()){
//            if(temp == null || m.getValue() > temp.getValue()){
//                temp = m;
//            }
//        }
//        return temp.getKey();

        int count = 0;
        int ret = 0;
        for (int num : nums) {
            if (count == 0) {
                ret = num;
            }
            count += (num == ret) ? 1 : -1;
        }
        return ret;
    }

    public static void moveZeroes(int[] nums) {
        Map<Integer, Integer> list = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                list.put(i, 0);
            }
        }
        for(Map.Entry<Integer, Integer> map : list.entrySet()){

        }
    }
}
