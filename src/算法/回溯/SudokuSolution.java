package 算法.回溯;

public class SudokuSolution {
    // TODO 在这里定义必要的全局变量
    boolean solved = false; // 是否已经正确解出数独
    // 其他全局变量...

    // TODO 在这里定义工具、辅助方法
    // 初始化，根据矩阵中已经填好的数字设置状态
    void init(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) 
                if (board[i][j] > 0) {
                    // TODO 在这里完成剩余代码
                    // ...
                } 
        }
    }
    // 其他方法...

    // 回溯解数独dfs：当前求解第i行第j列格子的数字
    // board为9x9矩阵，遵循以下规则：
    // 数字 1-9 在每一行只能出现一次。
    // 数字 1-9 在每一列只能出现一次。
    // 数字 1-9 在每一个 3x3 宫内只能出现一次。
    // board中已填的数字用1-9表示，未填的数字用0表示
    // 请将board中所有0的位置填写相应的数字，使得整个矩阵为一个有效的数独
    void dfs(int[][] board, int i, int j) {
        if (i == 9) { // 遍历完数独矩阵，即得到正确解
            solved = true;
            return;
        }

        // 先计算下一个格子的位置
        int next_i = i, next_j = j + 1;
        if (next_j == 9) {
            next_j = 0;
            next_i++;
        }
        
        if (board[i][j] == 0) {
            // TODO 在这里完成剩余代码
            // ...
        } else {
            // 当前格子存在数字，不需要搜索
            dfs(board, next_i, next_j); // 深度优先搜索下一个格子
            if (solved) return; // 若搜索结束后已经得到正确解，直接返回
        }
    }

    // 力扣37.解数独 入口方法
    public void solveSudoku(char[][] board) {
        int[][] nb = new int[9][9];
        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j)
                nb[i][j] = board[i][j] == '.' ? 0 : board[i][j] - '0';
        dfs(nb, 0, 0);
        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j)
                board[i][j] = (char)(nb[i][j] + 48);
    }

    public static void main(String[] args) {
        String name = "黄威朝"; // TODO 改成你自己的名字
        SudokuSolution sln = new SudokuSolution();
        System.out.println("====== " + name + "的题解作业5（回溯法）：测试开始 ======\n");


        int[][] board = new int[][] {new int[] {5,3,0,0,7,0,0,0,0},new int[] {6,0,0,1,9,5,0,0,0},new int[] {0,9,8,0,0,0,0,6,0},new int[] {8,0,0,0,6,0,0,0,3},new int[] {4,0,0,8,0,3,0,0,1},new int[] {7,0,0,0,2,0,0,0,6},new int[] {0,6,0,0,0,0,2,8,0},new int[] {0,0,0,4,1,9,0,0,5},new int[] {0,0,0,0,8,0,0,7,9}};
        sln.dfs(board, 0, 0);
        System.out.println("我的答案：");
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j)
                System.out.print("  " + board[i][j]);
            System.out.println();
        }
        if (check(board)) 
            System.out.println("\n答案正确！");
        else
            System.out.println("\n答案错误！");
        
        System.out.println("\n====== " + name + "的题解作业5：测试结束 ======");
    }

    // 检查数独是否正确
    static boolean check(int[][] a) {
        int r[] = new int[9], c[] = new int[9], g[] = new int[9];
        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j) {
                if (a[i][j] < 1 || a[i][j] > 9) return false;
                r[i] |= 1 << a[i][j] - 1;
                c[j] |= 1 << a[i][j] - 1;
                g[i / 3 * 3 + j / 3] |= 1 << a[i][j] - 1;
            }
        int[][] bb = { r, c, g };
        for (int[] b : bb) 
            for (int x : b) 
                if (x != 511) return false;
        return true; 
    }
}
