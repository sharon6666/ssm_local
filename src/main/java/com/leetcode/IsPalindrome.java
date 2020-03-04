package com.leetcode;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.leetcode
 * @Description: note
 * @Author:
 * @date: 2019-11-22 16:00
 * @UpdateUser:
 * @UpdateDate: 2019-11-22 16:00
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class IsPalindrome {
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null, pre_pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = pre_pre;
            pre_pre = pre;
        }
        if(fast != null){
            slow = slow.next;
        }
        while (pre != null && slow != null){
            if(pre.val != slow.val){
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args){
        ListNode s = new ListNode(1);
        s.next = new ListNode(2);
        s.next.next = new ListNode(2);
        s.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(s));
    }
}
