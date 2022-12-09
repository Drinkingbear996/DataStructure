package 算法.回溯.棋盘问题;

import java.util.HashSet;

// 51题：需要输出具体的题解方案
// 52题（本题）：不需要输出方案，只需要统计解的个数
public class P0052 {
    // 用全局变量存储答案和中间状态
    int N;
    int answerCount = 0; // 答案解的个数
    int times=0;
    // 记录行、列、斜线是否已放置皇后
    // 因为遍历是按行的顺序，所以不需要检查状态
    HashSet<Integer> columns = new HashSet<>();
    HashSet<Integer> leftX = new HashSet<>();
    HashSet<Integer> rightX = new HashSet<>();

    // 深度优先搜索
    // 将行号作为参数x：目标x=0 to N-1的遍历
    void dfs(int x) {
        if (x == N) {
            // 已搜索完最后一行，意味着得到一个有效解
            answerCount++;
            return;
        }

        // 回溯
        for (int y = 0; y < N; y++) {
            times++;
            if (!columns.contains(y) &&
                !leftX.contains(x - y) &&
                !rightX.contains(x + y)) {
                    // 放置皇后
                    // a[x][y] = 'Q';
                    columns.add(y);
                    leftX.add(x - y);
                    rightX.add(x + y);
                    // 递归调用，进行下一层搜索
                    dfs(x + 1);

                    // 状态还原
                    columns.remove(y);
                    leftX.remove(x - y);
                    rightX.remove(x + y);
            }
        }

    }

    public int totalNQueens(int n) {
        this.N = n;
        dfs(0);
        return answerCount;
    }

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        P0052 p=new P0052();
        p.totalNQueens(16);
        long end=System.currentTimeMillis();
        System.out.println("解的个数为："+p.answerCount);
        System.out.println("耗时："+(end-start)+"ms");
        System.out.println("搜索次数："+p.times);
    }
}
