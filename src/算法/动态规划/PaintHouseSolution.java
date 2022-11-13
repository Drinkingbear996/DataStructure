package 算法.动态规划;

public class PaintHouseSolution {

    /**
     * 问题描述：
     *      求粉刷房子的最小成本
     *      n: 房屋的数量
     *      redCosts[i]表示房屋[i]需要粉刷成红色所需要的价钱，blueCosts、greenCosts同理
     *
     *
     *
     * */

    /**
     * 解题思路：
     *          通过动态规划来求解，参考了leetcode198题的思路
     * */


    /**
     * 算法描述：
     *          1.dp[i][3]是第i个房子某个颜色以及i-1层另外两个颜色的最小值
     *          2.初始化dp[0][1-3]
     *          3.递推 dp[i][0] =   redCosts[i] + Math.min(dp[i - 1][1], dp[i - 1][2])
     * */

    /**
     * 复杂度分析：
     *
     * 时间复杂度和空间复杂度为O（n）
     * */

    /**
     * 讨论与总结：
     *      动态规划需要先确定dp的含义吧，想着想着容易混淆，然后再确认递推公式，
     *   最后是进行初始化，感觉很多题都要手动初始化i=0的情况，从i=1开始递推。
     * */

    public int minCost(int n, int[] redCosts, int[] blueCosts, int[] greenCosts) {
        // TODO 请完成minCost方法的代码实现

        //dp数组代表着第i个房子，
        int dp[][]=new int[n][3];
        dp[0][0] = redCosts[0];
        dp[0][1] = blueCosts[0];
        dp[0][2] = greenCosts[0];

        for (int i = 1; i < n; i++) {

      //
            //如果选的是红色，选前面另外两个元素的最小值，所以要初始化
            dp[i][0] =   redCosts[i] + Math.min(dp[i - 1][1], dp[i - 1][2]);

            //如果选的是蓝色
            dp[i][1] =  blueCosts[i] + Math.min(dp[i - 1][2], dp[i - 1][0]) ;

            //如果选的是绿色
            dp[i][2] =  greenCosts[i] + Math.min(dp[i - 1][0], dp[i - 1][1]) ;

        }

        return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }

    public static void main(String[] args) {
        String name = "黄威朝"; // TODO 改成你自己的名字
        PaintHouseSolution sln = new PaintHouseSolution();
        System.out.println("====== " + name + "的题解作业3：测试开始 ======\n");

        // 测试用例1，正确答案15
        int n1 = 3;
        int[] redCosts1 = { 17, 16, 14 }; // 用红色刷第0、1、2号房屋的成本分别是17、16、14
        int[] blueCosts1 = { 2, 1, 3 }; // 用蓝色刷每个房屋的成本
        int[] greenCosts1 = { 17, 10, 19 }; // 用绿色刷每个房屋的成本
        int ans1 = sln.minCost(n1, redCosts1, blueCosts1, greenCosts1);
        System.out.println("测试用例1 我的答案: " + ans1 + " 正确答案: 15\n");
        /**
         * 测试用例1答案说明：
         * 看得出每间房屋都是刷成蓝色最便宜，但受题目限制不可以三个房子都刷蓝色
         * 最优的方案是将0号和2号房子刷蓝色，总成本2+3=5
         * 然后中间的1号房子刷绿色，即greenCosts[1] == 10
         * 最后总花费=2+10+3=15
         */

        // 测试用例2，正确答案79
        int n2 = 13;
        int[] redCosts2 = { 10, 5, 6, 6, 17, 7, 8, 18, 3, 13, 1, 18, 10 };
        int[] blueCosts2 = { 14, 10, 16, 20, 15, 13, 17, 4, 13, 11, 11, 3, 4 };
        int[] greenCosts2 = { 14, 1, 14, 13, 16, 5, 6, 1, 4, 17, 3, 1, 9 };
        int ans2 = sln.minCost(n2, redCosts2, blueCosts2, greenCosts2);
        System.out.println("测试用例2 我的答案: " + ans2 + " 正确答案: 79\n");

        // 测试用例3，正确答案627
        int n3 = 100;
        int[] redCosts3 = { 1, 4, 6, 14, 6, 8, 13, 1, 7, 2, 14, 13, 15, 14, 5, 11, 3, 13, 7, 17, 3, 19, 5, 12, 10, 15, 15, 17, 3, 11, 5, 6, 14, 16, 6, 10, 4, 8, 12, 16, 2, 2, 2, 13, 3, 2, 15, 16, 11, 11, 2, 10, 11, 9, 3, 9, 15, 3, 5, 12, 9, 16, 17, 8, 19, 16, 10, 6, 19, 14, 14, 1, 15, 8, 8, 18, 5, 7, 10, 5, 19, 16, 14, 18, 13, 2, 16, 12, 17, 12, 2, 17, 4, 10, 11, 14, 20, 4, 8, 5 };
        int[] blueCosts3 = { 7, 19, 9, 10, 11, 5, 10, 5, 18, 17, 12, 8, 2, 10, 13, 18, 5, 8, 5, 3, 4, 3, 12, 2, 10, 1, 8, 2, 11, 20, 15, 2, 2, 11, 6, 15, 11, 12, 3, 19, 9, 18, 17, 7, 11, 4, 7, 8, 4, 10, 12, 18, 13, 7, 16, 9, 7, 7, 13, 17, 5, 13, 7, 17, 7, 4, 20, 18, 11, 6, 9, 9, 18, 6, 13, 5, 19, 19, 11, 10, 16, 12, 3, 11, 14, 10, 4, 13, 11, 15, 1, 17, 13, 8, 20, 15, 4, 18, 3, 3 };
        int[] greenCosts3 = { 15, 8, 20, 7, 4, 8, 9, 15, 18, 13, 6, 17, 4, 2, 5, 4, 8, 18, 3, 11, 5, 10, 15, 9, 1, 8, 8, 2, 20, 8, 8, 14, 10, 14, 6, 3, 14, 11, 11, 14, 17, 17, 13, 13, 9, 4, 4, 20, 5, 1, 1, 1, 4, 14, 4, 4, 8, 14, 9, 7, 1, 20, 1, 1, 6, 18, 18, 13, 20, 3, 13, 14, 17, 4, 11, 9, 3, 6, 14, 19, 10, 17, 13, 12, 10, 20, 5, 8, 8, 17, 2, 12, 11, 6, 6, 19, 2, 17, 12, 9 };
        int ans3 = sln.minCost(n3, redCosts3, blueCosts3, greenCosts3);
        System.out.println("测试用例3 我的答案: " + ans3 + " 正确答案: 627\n");

        System.out.println("====== " + name + "的题解作业3：测试结束 ======");
    }
}
