package 算法.动态规划;

public class leetcode1143_最长公共子序列 {

/**
 * 相似题 leetcode_72
 *
 *
 *
 dp[i][j]：长度为[0, i - 1]的s1与长度为[0, j - 1]的s2的最长公共子序列为dp[i][j]

 todo  思路：

 * s1[i - 1] == s2[j - 1]，那么找到了一个公共元素，dp[i][j] = dp[i - 1][j - 1] + 1;
 *
 * s1[i - 1] != s2[j - 1]，
 *
 *              s1[0, i - 2]与s2[0, j - 1]的最长公共子序列 (上边 dp[i-1][j])
 *
 *       MAX{
 *
 *              s1[0, i - 1]与s2[0, j - 2]的最长公共子序列，（左边 dp[i][j-1]）
 *
 *
 * */
 static public int longestCommonSubsequence(String s1, String s2) {

        //初始化dp数组，dp[i][j]代表着dp[0][0]-> dp[i-1][j-1]的最大公共子序列长度
        int dp[][]=new  int[s1.length()+1][s2.length()+1];
//从1开始
       for (int i = 1; i <= s1.length(); i++) {
            char c1=s1.charAt(i-1);

           System.out.print("dp i="+i+" :");
           for (int j =1; j <= s2.length(); j++) {
            char c2=s2.charAt(j-1);

               if (c1==c2){
                   dp[i][j]= dp[i-1][j-1]+1;
               } else
               {
                   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
               }
               System.out.print(dp[i][j] +" ");
           }
           System.out.println();
     }

       return  dp[s1.length()][s2.length()];




    }

    public static void main(String[] args) {

     String s1 = "ace", s2 = "abcde";

        System.out.println(longestCommonSubsequence(s1,s2));
    }

}
