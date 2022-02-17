package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/17
 */
public class RadixSort {
    public static void main(String[] args) {
        // int[] ints = {1, 5, 2, 58, 3, 9, 98, 21, 123};
        int[] ints = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            ints[i] = (int) (Math.random() * 800000000);
        }
        long start = System.currentTimeMillis();//运行前的时间
        // Arrays.sort(ints);//1004
        radixSort(ints);
        long end = System.currentTimeMillis();//运行前的时间1021
        System.out.println("运行时间为" + (end - start));
        // System.out.println(Arrays.toString(ints));
    }

    public static void radixSort(int[] ints) {
        //创建桶
        int[][] bucket = new int[10][ints.length];
        //记录每个桶实际上的数据
        int[] bucketNumber = new int[10];
        int index; //辅助放回原数组
        //得到最高位数长度
        int max = ints[0];
        for (int anInt : ints) {
            if (anInt > max) {
                max = anInt;
            }
        }
        int length = (max + "").length();
        //外层循环控制次数(最高位数长度)   number; //辅助找到个位,十位,百位
        for (int i = 0, number = 1; i < length; i++, number *= 10) {
            //放
            for (int anInt : ints) {
                //得到数组中的值,并判断放在哪个桶
                //找到位置(第一次个位,第二次十位...)
                int where = anInt / number % 10;
                //放到桶    bucketNumber[where]代表这个位置以及放了几个值
                bucket[where][bucketNumber[where]] = anInt;
                bucketNumber[where]++;
            }
            //拿
            //遍历统计桶中的数组个数的数组
            index = 0;//放回去的位置
            for (int k = 0; k < bucketNumber.length; k++) {
                //桶中有数据
                if (bucketNumber[k] != 0) {
                    //遍历得到数据
                    for (int j = 0; j < bucketNumber[k]; j++) {
                        ints[index] = bucket[k][j];
                        index++;
                    }
                }
                //得到数据后要把个数清空
                bucketNumber[k] = 0;
            }
        }
    }
}
