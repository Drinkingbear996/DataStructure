package 算法.动态规划;

import java.util.Arrays;

//todo 贪心法
public class leetcode1833_雪糕的最大数量 {
    /**
     * 雪糕 a[0...n-1] 价格 ，求数量A[k]
     *
     * */

    //总金额为c，下标i，从a[0....n-1]买最多的雪糕
    int buy(int [] a,int i, int c)
    {
        //取价钱最低的雪糕
        if (i==a.length)
            return 0;

        //
        int k=0;

        if(c>=a[i]){
            c=c-a[i];

            //变成子问题，用剩余的钱在剩余的雪糕里买最多的数量
            k=1+buy(a,i+1,c);

        }
        return k;
    }

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int k=buy(costs,0,coins);

        return k;
    }
    //证明  A=X1{x1,x2,.....xk}
    //A中必定包含a[0...n]里价钱最少的雪糕x1

    /**
     * 证明：反证法，存在一个更优的解
     //todo


     *  B={y1,y2,y3....ym} (m > k),且B中不包含x1
     *  取B中一支雪糕y1，可得y1 > x1
     *  在，B中移除y1放入x1
     *
     *  x1 +y2 + .... ym < y1 +... ym <= c
     *  我们就有B'{x1,y2,y3..ym}为最优解
     *  反证不成立
     * */

    public static void main(String[] args) {
// 举例       mississippi，定长编码
/**

 */

//哈夫曼编码，设计一种编码，令编码长度最短

/**        1.计算每个字母出现的频率：

        m:1
        p:2
        i:4
        s:4

            2.构建哈夫曼树

 取频率最小的两个数，构成左右树节点，取两数的和为父节点，直到所有数取完。


 */
    }
}
