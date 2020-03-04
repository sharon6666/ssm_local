package com.javese.集合;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashSortTest {
    public static void main(String[] args) {
        Integer[] a = {1, 4, 7, 43, 2, 8, 6, 9, 61, 3, 10, 17, 43};
        int j;
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                int temp = a[i];
                for (j = i; j >= gap && temp < a[j - gap]; j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = temp;
            }
        }
//        for (int aa : a) {
//            System.out.printf(aa + ",");
//        }

        int[] arr = {16, 7, 3, 20, 17, 8};

        heapSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }

        List<Integer> list = Arrays.asList(a);
        sort(list);
        for(Object ss : list){
            System.out.println(ss);
        }
    }

    /**
     * 堆排序
     */
    private static void heapSort(int[] arr) {
        //创建堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //重新对堆进行调整
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 调整堆
     *
     * @param arr    待排序列
     * @param parent 父节点
     * @param length 待排序列尾元素索引
     */
    private static void adjustHeap(int[] arr, int parent, int length) {
        //将temp作为父节点
        int temp = arr[parent];
        //左孩子
        int lChild = 2 * parent + 1;

        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= arr[lChild]) {
                break;
            }

            // 把孩子结点的值赋给父结点
            arr[parent] = arr[lChild];

            //选取孩子结点的左孩子结点,继续向下筛选
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        arr[parent] = temp;
    }

    private static void sort(List<Integer> arr) {
        if (!arr.isEmpty()) {
            List<Integer> small = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> big = new ArrayList<>();
            Integer key = arr.get(arr.size() / 2);
            for (Integer a : arr) {
                if (a > key) {
                    big.add(a);
                } else if(a < key){
                    small.add(a);
                }else{
                    same.add(a);
                }
            }
            sort(small);
            sort(big);
            arr = new ArrayList<>();
            arr.addAll(small);
            arr.addAll(same);
            arr.addAll(big);
        }
    }
}
