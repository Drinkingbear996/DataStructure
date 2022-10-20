package 算法.动态规划;

/**
 *题目是问有多少种方法走到第i层
 *
 *
 *
 * d[]代表着走到第i层的方法数，结合题目，不考虑d[0]的情况，从d[1]开始
 *
 * 例如i=3，在第3层
 * 可以由第1层走两步 / 第2层走一步达到，可以确立递推公式 d[i]=d[i-1]+d[i-2]
 * */
public class leetcode70_爬楼梯 {

    public int climbStairs(int n) {

        if(n<=1)
            return n;

        //d代表爬到第i层的方法种数
        int d[]=new int [n+1];

        d[1]=1;
        d[2]=2;

        //递推，第i层的种数是由i-1层
        for (int i = 3; i <= n; i++) {
            d[i]=d[i-1]+d[i-2];

        }
        return  d[n];

    }
}
