package com.leetcode;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.leetcode
 * @Description: note
 * @Author:
 * @date: 2019-11-22 9:31
 * @UpdateUser:
 * @UpdateDate: 2019-11-22 9:31
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode cur = listNode;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if(l1 == null){
            cur.next = l2;
        }else{
            cur.next = l1;
        }
        return listNode.next;

    }
}