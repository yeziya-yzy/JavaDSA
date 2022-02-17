package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/15
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        // int[] ints = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};E
        int[] ints = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            ints[i] = (int) (Math.random() * 800000000);
        }
        long start = System.currentTimeMillis();//运行前的时间
        // Arrays.sort(ints);//850
        shellSort(ints);
        long end = System.currentTimeMillis();//运行前的时间1783
        System.out.println("运行时间为" + (end - start));
        // System.out.println(Arrays.toString(ints));
    }

    public static void shellSort(int[] arr) {
        int index;
        int arrIndex;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                index = i;
                arrIndex = arr[index];
                while (index - gap >= 0 && arrIndex < arr[index - gap]) {
                    arr[index] = arr[index - gap];
                    index -= gap;
                }
                arr[index] = arrIndex;
            }
        }
    }
}