package com.datastructure.recursion;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/13
 * 八皇后问题
 */
public class Queen8 {
    //定义一个max表示有多少个皇后
    private final int max = 8;
    //定义数组array表示皇后的位置
    private final int[] array = new int[max];
    private static int count = 0;//排列个数

    public static void main(String[] args) {
        int[][] map = new int[8][8];
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println("count=" + count);
    }

    //编写一个方法，放置第n个皇后
    //特别注意： check 是 每一次递归时，进入到check中都有  for(int i = 0; i < max; i++)，因此会有回溯
    private void check(int n) {
        if (n == max) {  //n = 8 , 其实8个皇后就既然放好
            printQueen();
            return;
        }

        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后 n , 放到该行的第1列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) { // 不冲突
                //接着放n+1个皇后,即开始递归
                check(n + 1); //
            }
            //如果冲突，就继续执行 array[n] = i; 即将第n个皇后，放置在本行得 后移的一个位置
        }
    }

    //查看当我们放置第n个皇后, 就去检测该皇后是否和前面已经摆放的皇后冲突


    /**
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // 说明
            //1. array[i] == array[n]  表示判断 第n个皇后是否和前面的n-1个皇后在同一列
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后是否在同一斜线
            // n = 1  放置第 2列 1 n = 1 array[1] = 1
            // Math.abs(1-0) == 1  Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
            //3. 判断是否在同一行, 没有必要，n 每次都在递增
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //打印皇后位置
    private void printQueen() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+1 + " ");
        }
        System.out.println();
    }
}
