
150  200  300  400  500

#动态规划思路
1、确定dp数组（dp table）(备忘录数组)以及下标的含义
[comment]: <> ( 局部最优解)
2、确定递推公式 
3、dp数组如何初始化 
4、确定遍历顺序
5、举例推导dp数组

###题目
300（最长递增子序列）√  
1143(最长公共子序列) √ 
72(编辑距离)  
322(零钱兑换)（0 1背包）


#01背包问题

三种背包问题 
1.0-1背包问题，动态规划
2.背包问题，物品可以买一部分
3.特殊背包问题，价值都为1。

背包问题变为2、3的时候可以用贪心法求解

###推荐题目
322、1049


###01背包问题模板 求最大值
```java
//d[i][j] 前i个物品，重量不超过j时的最大价值
//重量{2,2,6,5,4}  对应价值{6,3,5,4,6}

//d[i][j] = max {d[i-1][j],d[i-1][j - w(i)] + v(i)] }


public class Bag01{

    //价值
  static   public int v(int v)
    {
        return v;
    }

    //重量
  static   public int w(int w)
    {
        return  w;
    }

    //01背包模板，有n件物品，背包容量为c
   static public int knapsack(int n ,int c)
    {
        int dp[] =new int[c+1];
        for (int i = 0; i < n; i++) {
            for(int j=c;j>=w(i);j--)
            {
                dp[j]=Math.max(dp[j],dp[j-w(i)]+v(i));
            }
        }
        return  dp[c];
    }

    public static void main(String[] args) {
        System.out.println(knapsack(10,5));
    }
}

```
#贪心法(思想)

435(活动安排问题) 1833(雪糕的最大数量)

### 动态规划和贪心法区别
    贪心法，每一步局部最优解，再解子问题，不一定全局最优，需要证明是否正确
    动态规划，把每一步子问题都解出来，再找最优路线。

[comment]: <> (如果能用贪心法求解，结果最优、效率高，但需要证明贪心法正确性)


```java

```