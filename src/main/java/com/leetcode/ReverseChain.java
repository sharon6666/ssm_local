package com.leetcode;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.leetcode
 * @Description: note
 * @Author:
 * @date: 2019-11-21 13:30
 * @UpdateUser:
 * @UpdateDate: 2019-11-21 13:30
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class ReverseChain {
    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next= new ListNode(4);
        System.out.println(reverseList(head));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}