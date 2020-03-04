package com.javese.集合;


/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.javese.集合
 * @Description: note
 * @Author:
 * @date: 2019-11-26 14:14
 * @UpdateUser:
 * @UpdateDate: 2019-11-26 14:14
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class ColletionTest {

    public static void main(String[] args){
        ListNode list = new ListNode(-1);
        list.next = new ListNode(4);
        list.next.next = new ListNode(6);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(7);
        System.out.println(list);
        System.out.println(detectCycle(list));
    }
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                return slow;
            }
        }
        return null;
    }

    /**
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     *
     * 作者：凯玲之恋
     * 链接：https://www.jianshu.com/p/6ebedde370b0
     * 来源：简书
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public static void sort(ListNode head){

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