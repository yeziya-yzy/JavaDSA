package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/15
 * 插入排序(前面的后移,后面的往前面去)
 */
public class InsertSort {
    public static void main(String[] args) {
        // int[] arr = new int[]{5, 3, 9, 7, 6};
        int[] ints = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            ints[i] = (int) (Math.random() * 800000000);
        }
        long start = System.currentTimeMillis();//运行前的时间
        // Arrays.sort(ints);//20
        insertSort(ints);
        long end = System.currentTimeMillis();//运行前的时间 476
        System.out.println("运行时间为" + (end - start));
    }

    //插入排序
    public static void insertSort(int[] arr) {
        int indexUse;
        int arrIndex;
        for (int i = 1; i < arr.length; i++) {
            indexUse = i - 1;  //插入数前一个位置
            arrIndex = arr[i];  //要插入的数
            while (indexUse >= 0 && arrIndex < arr[indexUse]) {
                //后移
                arr[indexUse + 1] = arr[indexUse];
                indexUse--;
            }
            arr[indexUse + 1] = arrIndex;
        }
    }
}