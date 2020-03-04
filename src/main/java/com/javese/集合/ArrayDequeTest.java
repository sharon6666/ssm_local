package com.javese.集合;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangrx23694
 * @date
 * @description
 */
public class ArrayDequeTest {
    public static void main(String[] args){
        Integer[] arr = {1,4,6,3,44,23,7,7,3,2,6,8,4,8};
        List<Integer> list = Arrays.asList(arr);
        ArrayDeque ad = new ArrayDeque(list);
//        for(int i=0;i<arr.length;i++){
//            if(i%1 == 0){
//                ad.addFirst(arr[i]);
//            }else{
//                ad.addLast(arr[i]);
//            }
//        }
//        while(!ad.isEmpty()){
//            System.out.println(ad.pollFirst());
//            System.out.println(ad.pollLast());
//        }
//        ad.clear();
//        for(Integer aa : arr) {
//            ad.addFirst(aa);
//        }
        while(!ad.isEmpty()){
            System.out.println(ad.pollLast());
        }
    }
}
