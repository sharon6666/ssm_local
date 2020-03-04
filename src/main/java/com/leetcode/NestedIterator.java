package com.leetcode;

import java.util.*;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.leetcode
 * @Description: note
 * @Author:
 * @date: 2019-11-20 11:09
 * @UpdateUser:
 * @UpdateDate: 2019-11-20 11:09
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class NestedIterator implements Iterator<Integer> {
    // 构造一个栈 栈顶元素存放的是当前活跃的列表
    LinkedList<Iterator<NestedInteger>> stack = null;
    Integer num = null;
    boolean flag = false;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<Iterator<NestedInteger>>();
        stack.addFirst(nestedList.iterator());
    }

    @Override
    public Integer next() {
        flag = false;
        return num;
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) return false;
        // 取出栈顶活跃的迭代器
        while (!stack.isEmpty() && !flag) {
            // 取出栈顶元素
            Iterator<NestedInteger> iterator = stack.peekFirst();
            if (!iterator.hasNext()) {
                // 如果栈顶的迭代器已经是空了就出栈
                stack.pollFirst();
            } else {
                NestedInteger next = iterator.next();
                if (next == null) continue;
                if (next.isInteger()) {
                    num = next.getInteger();
                    flag = true;
                    iterator.remove();
                } else {
                    stack.offerFirst(next.getList().iterator());
                    iterator.remove();
                }
            }
        }
        return flag;
    }


    /**
     * 递归方法
     */
    Queue<Integer> list;
    /*
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>();
        circle(nestedList);
    }

    public void circle(List<NestedInteger> nestedList){
        if(nestedList == null){
            return;
        }
        for(NestedInteger i : nestedList){
            if(i.isInteger()){
                list.offer(i.getInteger());
            }else{
                circle(i.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return list.poll();
    }

    @Override
    public boolean hasNext() {
        return list.size()>0;
    }*/
}
