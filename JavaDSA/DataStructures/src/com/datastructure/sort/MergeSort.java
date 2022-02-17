package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/16
 * 归并(递归分开,递归排序)
 */
public class MergeSort {
    private static final int max = 8000000;
    private static final int[] arrHelp = new int[max];

    public static void main(String[] args) {
        // int[] ints = {1, 5, 2, 58, 3, 9, 98, 21};
        int[] ints = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            ints[i] = (int) (Math.random() * 800000000);
        }
        long start = System.currentTimeMillis();//运行前的时间
        // Arrays.sort(ints);//762
        mergeSort(ints, 0, ints.length - 1);
        long end = System.currentTimeMillis();//运行前的时间1019
        System.out.println("运行时间为" + (end - start));
        // System.out.println(Arrays.toString(ints));
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        addArr(arr, left, mid, right);
    }

    //把两个数组和为一个数组
    public static void addArr(int[] arr, int left, int mid, int right) {
        //第一个数组
        int indexLeft = left;
        int indexRight = mid + 1;
        int indexHelp = left;
        //把小的放到辅助数组中
        while (indexLeft <= mid && indexRight <= right) {
            if (arr[indexLeft] < arr[indexRight]) {
                arrHelp[indexHelp] = arr[indexLeft];
                indexHelp++;
                indexLeft++;
            } else {
                arrHelp[indexHelp] = arr[indexRight];
                indexHelp++;
                indexRight++;
            }
        }
        //如果有一个还没越界,就把这一个全部放上去
        while (indexLeft <= mid) {
            arrHelp[indexHelp] = arr[indexLeft];
            indexHelp++;
            indexLeft++;
        }
        while (indexRight <= right) {
            arrHelp[indexHelp] = arr[indexRight];
            indexHelp++;
            indexRight++;
        }
        //拷贝回去
        // for (int i = left; i <= right; i++) {
        //     arr[i] = arrHelp[i];
        // }
        if (right + 1 - left >= 0) System.arraycopy(arrHelp, left, arr, left, right + 1 - left);
    }
}
