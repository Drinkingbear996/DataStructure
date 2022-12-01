package 算法.动态规划;
//todo 背包问题
public class leetcode322_零钱兑换 {


    int coins[], dp[];

    // 返回面额m所需的最小硬币数
    // 返回-1表示无解
    int dpdfs(int m) {
        // 边界条件
        if (m == 0) return 0;

        // 如已创建备忘录，直接读取
        if (dp[m] != 0)
            return dp[m];

        dp[m] = -1;
        for (int c : coins)
            if (c <= m) {
                // 回溯，取了当前硬币之后搜索找零剩下的钱最少要几个硬币
                int next = dpdfs(m - c);

                // 更新当前最优解（以及更新备忘录）
                if (next >= 0 && (dp[m] < 0 || next + 1 < dp[m]))
                    dp[m] = next + 1;
            }
        return dp[m];
    }

    // 方法二：记忆化回溯
    public int coinChange_Memorization(int[] coins, int amount) {
        this.coins = coins;
        dp = new int[amount + 1];
        return dpdfs(amount);
    }

    // 方法一：动态规划
    public int coinChange_DP(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 0; i < amount; ++i) {
            if (i == 0 || dp[i] > 0) { // 细节1：dp[i]==0表示没有任何方法可以凑出面额i，这时计算就要跳过
                for (int c: coins) {
                    if (c <= amount - i) { // 细节2：当心数组越界
                        int a = i + c; // 当前新的面额
                        int cnt = dp[i] + 1; // 组成面额a所需的硬币数
                        if (dp[a] == 0 || dp[a] > cnt)
                            dp[a] = cnt;
                    }
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount]; // 留意题目要求
    }
}
