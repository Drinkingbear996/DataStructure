package 数据结构.递归;



public class TowersOfHanoi {


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


    /**
     *        实现这个算法可以简单分为三个步骤：

 　　（1）中间一步之上可以看成把A上n-1个盘子通过借助辅助塔（C塔）移到了B上，

     （2）中间的一步是把最大的一个盘子由A移到C上去；

   　（3）中间一步之下可以看成把B上n-1个盘子通过借助辅助塔（A塔）移到了C上；

     * */

    static int mobile =0;//标记移动次数
    //实现移动的函数
    public static void move(int panel,String N,String M)
    {
        mobile++;
        System.out.println("第" + mobile +" 次移动 : " +" 把 "+ panel+" 号圆盘从 " + N +" ->移到->  " + M);
    }
    //递归实现汉诺塔的函数
    public static void function(int n,String A,String B,String C)
    {
        if(n == 1)//圆盘只有一个时，只需将其从A塔移到C塔
            TowersOfHanoi.move(1, A, C);//将编号为1的圆盘从A移到C
        else
        {
            function(n - 1, A, C, B);//递归，把A塔上编号1~n-1的圆盘移到B上，以C为辅助塔
            TowersOfHanoi.move(n, A, C);//把A塔上编号为n的圆盘移到C上
            function(n - 1, B, A, C);//递归，把B塔上编号1~n-1的圆盘移到C上，以A为辅助塔
        }
    }
    public static void main(String[] args) {
        int panel = 14;
        TowersOfHanoi.function(panel, "A", "B", "C");
        System.out.println("移动了" + mobile + "次，把A上的圆盘都移动到了C上");
    }
}

//时间复杂度 O(2^n)



