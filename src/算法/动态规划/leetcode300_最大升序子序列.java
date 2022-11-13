package 算法.动态规划;

import java.util.Arrays;

public class leetcode300_最大升序子序列 {

/**
 * dp[i]的定义
 * dp[i]表示i之前包括i的以nums[i]结尾最长上升子序列的长度
 *
 * 状态转移方程
 * 位置i的最长升序子序列等于j从0到i-1各个位置的最长升序子序列 + 1 的最大值。
 *
 * 所以：if (a[i] > a[j]) dp[i] = max(dp[i], dp[j] + 1);
 *
 * dp[i]的初始化
 * 每一个i，对应的dp[i]（即最长上升子序列）起始大小至少都是1.
 *
 * 确定遍历顺序
 * dp[i] 是有0到i-1各个位置的最长升序子序列 推导而来，那么遍历i一定是从前向后遍历。
 *
 * */
  static   public int lengthOfLIS(int[] a) {
        int[] dp = new int[a.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

//            打印dp
            for (int k = 0; k < dp.length; k++) {
                System.out.print(dp[k]+" ");
            }
            System.out.println();
        }
        int res = 0;
        //得出的数组是无序的，用res找最大值
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int a []=new int[]{0,1,0,3,2,3};
        lengthOfLIS(a);
    }
}



