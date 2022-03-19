package 数据结构.数组;

import java.util.*;



public class 旋转矩阵 {

    /**
     * https://leetcode-cn.com/leetbook/read/array-and-string/clpgd/
     * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
     *
     * 不占用额外内存空间能否做到？
     * n x n的矩阵翻转90度
     * 最直白蛮力的方法，先转置矩阵，后镜像对称
     *
     * */

  static   int[][]  test1(int a[][],int n)
    {
        //j<i 很重要，不会出现重复交换 a[i][j]=a[j][i] a[j][i]=a[i][j] 这种情况。
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp=a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=temp;
            }
        }
        for (int i = 0; i <n; i++) {
            // a.length/2 如果为奇数中间那行不变，其余行对称交换;如果为偶数则对称交换
            //
            for (int j = 0; j < a.length/2; j++) {
                //从最后的列往前数
                int end=a.length-1-j;
                //中间容器，用于交换
                int temp=a[i][j];
                a[i][j]= a[i][end];
                a[i][end]=temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }


        return a;
    }


    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();

        int a[][]=new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j]=in.nextInt();
            }
        }

      test1(a,n);







    }




}
