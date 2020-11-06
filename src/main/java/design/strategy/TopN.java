package design.strategy;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        int child = (i << 1) + 1; // 当前节点的左孩子
        int temp = arr[i];

        while (child <= end) {
            // 选出两个孩子较大的那个
            if (child < end && arr[child + 1] > arr[child]) {
                child++;
            }
            if (temp < arr[child]) {
                arr[i] = arr[child]; // 孩子节点与当前节点替换
                i = child;
                child = (i << 1) + 1;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    public static void headSort(int[] arr) {
        // 取出堆顶元素，与最后一个元素交换，调整堆
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i]; // 最后一个元素
            arr[i] = arr[0];
            arr[0] = temp;
            adjust(arr, 0, i - 1);

        }
    }

    public static void main(String[] args) {
        int[] arr = {19, 17, 20, 18, 16, 21};
        createHeap(arr); // 创建堆
        headSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

//        FileReader reader = null;
//        try {
//            reader = new FileReader("../../..");
//            BufferedReader br = new BufferedReader(reader);
//
//            String line;
//            List<Integer> list = new ArrayList<>();
//            int[] arr = new int[100];
//            // 100 0000 0000
//            TopN n = new TopN();
//            while ((line = br.readLine()) != null) {
//                int a = Integer.parseInt(line);
//                if (list.size() < 99) {
//                    arr[]
//                } else if (list.size() == 99) {
//                    cr(100, );
//                } else {
//                    adjust();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
