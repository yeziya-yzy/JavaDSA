package com.datastructure.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/15
 * 选择排序(找到最小的放到前面,一次确认一个最小的)
 */
public class SelectSort {
    public static void main(String[] args) {
        // int[] ints = {8, 7, 6, 5, 1};
        int[] ints = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            ints[i] = (int) (Math.random() * 800000000);
        }
        long start = System.currentTimeMillis();//运行前的时间
        // Arrays.sort(ints);//20
        SelectSort.selectSort(ints);
        long end = System.currentTimeMillis();//运行前的时间 2050(80000次)
        System.out.println("运行时间为" + (end - start));
    }

    public static void selectSort(int[] arr) {
        int min;
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        // 输出
        // for (int item : arr) {
        //     System.out.println(item);
        // }
    }
}