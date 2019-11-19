package com.leetcode;

import jdk.nashorn.internal.objects.NativeUint8Array;

import java.util.Stack;

/**
 * @date: 2019-11-18 17:19
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution {
    // 思路很巧妙 但是速度慢
    public static boolean isValid(String s) {
        /*while (s.indexOf("()") >= 0|| s.indexOf("{}") >= 0|| s.indexOf("[]") >= 0){
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s.equals("");*/

//        Stack<String> stack = new Stack<String>();
//        for (int i = 0; i < s.length(); i++) {
//            // 获取每个左括号的值
//            if (s.charAt(i) != '}' && s.charAt(i) != ']' && s.charAt(i) != ')') {
//                stack.push(s.substring(i, i + 1));
//            } else if (s.charAt(i) == '}') { // 如果为空 说明没有左括号 返回false； 如果去的前一个值不匹配也返回false  否则pop栈的数据 说明有匹配成功的。
//                if (stack.isEmpty() || !stack.peek().equals("{"))
//                    return false;
//                stack.pop();
//            } else if (s.charAt(i) == ']') {
//                if (stack.isEmpty() || !stack.peek().equals("["))
//                    return false;
//                stack.pop();
//            } else if (s.charAt(i) == ')') {
//                if (stack.isEmpty() || !stack.peek().equals("("))
//                    return false;
//                stack.pop();
//            }
//        }
//        return stack.isEmpty();
        char[] arr = s.toCharArray();
        if(arr.length % 2 != 0){
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(isValid("()[{]}()"));
    }

}
