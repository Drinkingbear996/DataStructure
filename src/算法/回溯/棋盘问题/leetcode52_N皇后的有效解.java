package 算法.回溯.棋盘问题;

import java.util.HashSet;

/**
 * 补充 对角线判断
 * 左斜对角线判断： x1-y1== x2-y2
 * 右斜对角线判断： x1+y1== x2+y2
 */
public class leetcode52_N皇后的有效解 {
    int N;
    int answerCount; //解的个数

    //判断左右斜线，列是否有方式皇后
    HashSet<Integer> columns = new HashSet<>();
    HashSet<Integer> leftX = new HashSet<>();
    HashSet<Integer> rightX = new HashSet<>();

    void dfs(int x) {
        //递归终止条件，到达最后一层，证明有解
        if (x == N) {
            answerCount++;
            return;
        }

        //回溯
        for (int y = 0; y < N; y++) {
            if (!columns.contains(y) &&
                !leftX.contains(x - y) &&
                !rightX.contains(x + y)) {
                //放皇后
                columns.add(y);
                leftX.add(x-y);
                rightX.add(x+y);
                //该层搜索完毕,进入下一层
                dfs(x+1);

                //状态还原
                columns.remove(y);
                leftX.remove(x-y);
                rightX.remove(x+y);
            }
        }
    }


}
