package 数据结构.数组;

import java.util.Scanner;

/**
 * https://leetcode-cn.com/leetbook/read/array-and-string/ciekh/
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零
 * */
public class 零矩阵 {

    public static void setZeroes(int[][] matrix) {

    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        //记录为0的行
        boolean [] row=new boolean[m];
        //记录为0的列

        boolean [] column=new boolean[n];
        int a[][]=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j]=in.nextInt();
                //如果输入0，对应行和列的索引都标记为true
                if (a[i][j]==0)
                {
                    row[i]=true;
                    column[j]=true;
                }

            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //遍历，标记为true的行和列索引就设为0
                if (row[i]==true||column[j]==true)
                {
                    a[i][j]=0;
                }
            }
        }



    }
}
