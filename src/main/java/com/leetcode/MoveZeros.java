package com.leetcode;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.leetcode
 * @Description: note
 * @Author:
 * @date: 2019-11-29 15:20
 * @UpdateUser:
 * @UpdateDate: 2019-11-29 15:20
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 *     给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class MoveZeros {

    public static void main(String[] arg){
        int []arr = {1,4,0,4,0,1};
        int []b = moveZero(arr);
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }

    public static int[] moveZero(int []nums){

        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == 0){
                int temp = nums[i+1];
                nums[i] = temp;
                nums[i+1] = 0;
            }
        }
        return nums;
    }
}
