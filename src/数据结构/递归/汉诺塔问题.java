package 数据结构.递归;

import java.util.Scanner;


public class 汉诺塔问题 {


    /**
问题描述
     *  题目：总共有14个盘子，三个石柱（A、B、C），小盘子只能位于大盘子上方，且每次只能移动一个盘子
     *  目标：把所有盘子从A -> C，，由小到大排列
     *  输入：初始盘子数n
     *  输出：最终盘子状态 和 总共移动的步数
     *
     *
     * */

    /**
解题思路
     * n为盘子数，times为移动次数
     * n: 1  times：1
     * n: 2  times：3
     * n: 3  times：7
      递推公式得 移动次数 times = 2^n - 1
     * */
    //

 static void  move(int n,String a,String b,String c)
 {
     if (n==1)
     {
         System.out.println(a+"移动到了"+c);
     } else{
         move(n-1,a,c,b);
         System.out.println(a+"移动到了"+c);
         move(n-1,b,a,c);
     }

 }

    public static void main(String[] args) {
         move(3,"a","b","c");
    }
}

/**
 * https://www.cnblogs.com/dmego/p/5965835.html
 */
class TowersOfHanoi
{
    /**
    *        实现这个算法可以简单分为三个步骤：
     *
     * 　　　　（1）     把n-1个盘子由A 移到 B；
     *
     * 　　　　（2）     把第n个盘子由 A移到 C；
     *
     * 　　　　（3）     把n-1个盘子由B 移到 C；
     *
     * 从这里入手，在加上上面数学问题解法的分析，我们不难发现，移到的步数必定为奇数步：
     *
     * 　　　　（1）中间的一步是把最大的一个盘子由A移到C上去；
     *
     * 　　　　（2）中间一步之上可以看成把A上n-1个盘子通过借助辅助塔（C塔）移到了B上，
     *
     * 　　　　（3）中间一步之下可以看成把B上n-1个盘子通过借助辅助塔（A塔）移到了C上；
    *
    *
    *
    * */

        static int m =0;//标记移动次数
        //实现移动的函数
        public static void move(int disks,String N,String M)
        {
            m++;
            System.out.println("第" + m +" 次移动 : " +" 把 "+ disks+" 号圆盘从 " + N +" ->移到->  " + M);
        }
        //递归实现汉诺塔的函数
        public static void hanoi(int n,String A,String B,String C)
        {
            if(n == 1)//圆盘只有一个时，只需将其从A塔移到C塔
                TowersOfHanoi.move(1, A, C);//将编b号为1的圆盘从A移到C
            else
            {
                hanoi(n - 1, A, C, B);//递归，把A塔上编号1~n-1的圆盘移到B上，以C为辅助塔
                TowersOfHanoi.move(n, A, C);//把A塔上编号为n的圆盘移到C上
                hanoi(n - 1, B, A, C);//递归，把B塔上编号1~n-1的圆盘移到C上，以A为辅助塔
            }
        }
        public static void main(String[] args) {
            Scanner imput = new Scanner(System.in);
            String A = "A";
            String B = "B";
            String C = "C";
            System.out.println("******************************************************************************************");
            System.out.println("这是汉诺塔问题（把A塔上编号从小号到大号的圆盘从A塔通过B辅助塔移动到C塔上去");
            System.out.println("******************************************************************************************");
            System.out.print("请输入圆盘的个数：");
            int disks = imput.nextInt();
            TowersOfHanoi.hanoi(disks, A, B, C);
            System.out.println(">>移动了" + m + "次，把A上的圆盘都移动到了C上");
            imput.close();
        }

    }
