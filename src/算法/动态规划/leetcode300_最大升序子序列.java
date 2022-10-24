package 算法.动态规划;

import java.util.Arrays;

public class leetcode300_最大升序子序列 {


  static   public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

//            打印dp
//            for (int k = 0; k < dp.length; k++) {
//                System.out.print(dp[k]+" ");
//            }
//            System.out.println();
        }
        int res = 0;
        //得出的数组是无序的，用res找最大值
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int a []=new int[]{1,3,6,7,9,4,10,5,6};
        lengthOfLIS(a);
    }
}



