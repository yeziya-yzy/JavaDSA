package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/15
 * 快速排序(递归,双指针)  相同的数字非常多会出现StackOverflowError
 */
public class QuickSort {
    public static void main(String[] args) {
        // int[] ints = {1, 5, 2, 58, 3, 12, 12, 12, 12};
        int[] ints = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            ints[i] = (int) (Math.random() * 800000000);
        }
        long start = System.currentTimeMillis();//运行前的时间
        // Arrays.sort(ints);//1000
        quickSort(ints, 0, ints.length - 1);
        long end = System.currentTimeMillis();//运行前的时间1047
        System.out.println("运行时间为" + (end - start));
        // System.out.println(Arrays.toString(ints));
    }

    public static void quickSort(int[] arr, int left, int right) {
        //安全校验,也就是退出条件
        if (left >= right) {
            return;
        }
        int l = left + 1;//左指针
        int r = right;//右指针
        int number = arr[left];
        int temp;//交换用的辅助变量
        int where; //截断的位置
        while (true) {
            //找到比标准小的值
            while (r > left && arr[r] > number) {
                r--;
            }
            //找到比标准大的值
            while (l < right && arr[l] < number) {
                l++;
            }
            //防止把交换好的再找到又交换和找到通一个数
            if (l >= r) {
                break;
            }
            //防止想同的数太多
            if (arr[r] == arr[l]) {
                l++;
            }
            //把找到的数交换一下
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;

        }
        temp = arr[left];
        arr[left] = arr[r];
        arr[r] = temp;
        where = r;
        quickSort(arr, left, where - 1);
        quickSort(arr, where + 1, right);
    }
}