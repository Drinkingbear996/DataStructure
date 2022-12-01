package 算法.回溯;
import java.util.*;
public class 回溯_01背包 {

        // 重量及背包容量必须为整数
        static double w[], v[];
        static double hasValue = 0.0, // 当前装入背包的总价值
                maxValue = 0.0; // 搜索到的最大物品总价值

        // 当前搜索第i件物品
        // 枚举：放入或不放入背包中
        static void dfs(int i, int n, double c) {
            if (i == n) {
                if (c >= 0) {
                    if (hasValue > maxValue)
                        maxValue = hasValue;
                }
                return;
            }

            // 回溯：对于物品i，可以放入或不放入背包
            // 情形1：放入背包
            hasValue += v[i];
            c -= w[i];
            dfs(i + 1, n, c);
            hasValue -= v[i];
            c += w[i];

            // 情形2：当前物品不放进背包
            dfs(i + 1, n, c);
        }
        static double knapsack(int n, double c) {
            dfs(0, n, c);
            return maxValue;
        }

        // 重量为整数时可用动态规划求解
//	static int knapsack(int n, int c) {
//		int[] dp = new int[c + 1];
//		for (int i = 0; i < n; i++) {
//			for (int j = c; j >= w[i]; j--)
//				dp[j] = Math.max(dp[j],  dp[j - w[i]] + v[i]);
//		}
//		return dp[c];
//	}

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int t = scan.nextInt();
            while (t-- > 0) {
                int n = scan.nextInt();
                double c = scan.nextDouble();
                w = new double[n];
                v = new double[n];
                for (int i = 0; i < n; i++)
                    w[i] = scan.nextDouble();
                for (int i = 0; i < n; i++)
                    v[i] = scan.nextDouble();

                double ans = knapsack(n, c);

                System.out.println(ans);

            }
            scan.close();

            // 重量为整数的情形：可用动态规划
//		Scanner scan = new Scanner(System.in);
//		int t = scan.nextInt();
//		while (t-- > 0) {
//			int n = scan.nextInt(), c = scan.nextInt();
//			w = new int[n];
//			v = new int[n];
//			for (int i = 0; i < n; i++)
//				w[i] = scan.nextInt();
//			for (int i = 0; i < n; i++)
//				v[i] = scan.nextInt();
//
//			int ans = knapsack(n, c);
//
//			System.out.println(ans);
//
//		}
//		scan.close();
        }
    }


