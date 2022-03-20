package 数据结构.数组;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://leetcode-cn.com/leetbook/read/array-and-string/cuxq3/
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 *
 * */
public class leetcode498_对角线遍历 {

    public static  int[] Solution(int a[][])
    {
       int  m=a.length;
       int  n=a[0].length;
        //题可得，右，左下，下，右上，这四种方向 按照这个顺序搜索

        //这里的xy是坐标移动的位置
        int dx[]={0,1,1,-1};
        int dy[]={1,-1,0,1};

        int x=0,y=0;
        //记录哪些点是被访问过
        boolean[][] bool=new boolean[m][n];

        //记录结果
        ArrayList<Integer> res=new ArrayList<>();

        //控制走的位置
        int d=0;


        for (int k = 1; k <=m*n; k++) {

            res.add(a[x][y]);
            //记录该元素被找到
            bool[x][y]=true;
            //如果是最后一个元素，跳出
            if (k==m*n)
            {
                break;
            }

            //利用(i,j)找到下一个可以走的点
            int i=x+dx[d];
            int j=y+dy[d];

            //判断是否满足条件 （如越界，或者该点已经被标记过）,就继续找，直到符合条件
            while(i<0 || i>=m || j<0|| j>=n || bool[i][j]==true)
            {
                d=(d+1)%4;
                i=x+dx[d];
                j=y+dy[d];
            }

            //出循环证明条件符合

            //让(i,j)变成下一个可以走的点，进入下一个循环
            x=i;
            y=j;

            //如果是这次是向右或者向下走，则改变方向变为斜着走
            if (d==0||d==2)
            {
                d=(d+1)%4;
            }

        }


        int res_array[]=new int[m*n];
        for (int i = 0; i < res.size(); i++) {
            res_array[i]=res.get(i);

        }
        return  res_array;
    }


    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        int n =in.nextInt();

        int a[][]=new int[m][n];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <a[0].length; j++) {
                a[i][j]=in.nextInt();
            }
        }


     int res[]= Solution(a);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }

    }
}
