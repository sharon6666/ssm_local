package design.strategy;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * @author wangrx23694
 * @date
 * @description
 */
public class TopN {

    public static void createHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length - 1);
        }
    }

    public static void adjust(int[] arr, int i, int end) {
        // 当前节点的左孩子
        int child = (i * 2) + 1;
        int temp = arr[i];

        while (child <= end) {
            // 选出两个孩子较大的那个
            if (child < end && arr[child + 1] > arr[child]) {
                child++;
            }
            if (temp < arr[child]) {
                arr[i] = arr[child];
                i = child;
                child = (i * 2) + 1;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    public static void headSort(int[] arr) {
        // 取出堆顶元素，与最后一个元素交换，调整堆
        for (int i = arr.length - 1; i >= 0; i--) {
            // 最后一个元素
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjust(arr, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr1 = new int[1000];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = random.nextInt();
        }

        int[] arr = new int[100];
        FileReader reader = null;
        try {
            reader = new FileReader("../../..");
            BufferedReader br = new BufferedReader(reader);
            String line;
            int i = 0;
            // 100 0000 0000
            while ((line = br.readLine()) != null) {
                int a = Integer.parseInt(line);
                if (arr.length < 99) {
                    arr[i] = a;
                } else if (arr.length == 99) {
                    createHeap(arr);
                } else {
                    // 取更小的值
                    if (a < arr[0]) {
                        arr[99] = a;
                        headSort(arr);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
