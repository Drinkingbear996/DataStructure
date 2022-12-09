package 算法.回溯;

public class SudokuSolution {
    // TODO 在这里定义必要的全局变量
    boolean solved = false; // 是否已经正确解出数独
    // 其他全局变量...

    // TODO 在这里定义工具、辅助方法
    private boolean solveSudokuHelper(int[][] board){
        //一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，
        // 一行一列确定下来之后，把9个数字都试一下
        for (int i = 0; i < 9; i++){ // 遍历行
            for (int j = 0; j < 9; j++){ // 遍历列

                if (board[i][j] != 0){ // 跳过原始数字,添加结果数组
                    continue;
                }

                for (int k = 1; k <= 9; k++){ // (i, j) 这个位置放k是否合适
                    if (isValidSudoku(i, j, k, board)){
                        board[i][j] = k;

                        if (solveSudokuHelper(board)){ // 如果找到合适一组立刻返回
                            return true;
                        }
                        board[i][j] = 0;
                    }
                }
                // 9个数都试完了，都不行，那么就返回false
                return false;
                // 因为如果一行一列确定下来了，这里尝试了9个数都不行，说明这个棋盘找不到解决数独问题的解

            }
        }
        // 遍历完没有返回false，说明找到了合适棋盘位置了
        return true;
    }

    /**
     * 判断棋盘是否合法有如下三个维度:
     *     同行是否重复
     *     同列是否重复
     *     9宫格里是否重复
     * @param board 棋盘二维数组
     * @param col   当前格子的纵坐标
     * @param row   当前格子的横坐标
     * @param val   当前格子的测试值
     */
    private boolean isValidSudoku(int row, int col, int val, int[][] board){
        // 同行是否重复
        for (int i = 0; i < 9; i++){
            if (board[row][i] == val){
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++){
            if (board[j][col] == val){
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++){
            for (int j = startCol; j < startCol + 3; j++){
                if (board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }

    // 力扣37.解数独 入口方法
    public void solveSudoku(int[][] board) {

            solveSudokuHelper(board);
    }

    /**
     * 问题描述：
     *        求解内容：求解数独，只有一个解
     *        输入：int[][]board
     *        输出：遍历 board
     *
     * */

    /**
     * 解题思路：
     *         1.在数组中，若board[i][j]=0,则在1-9中选择元素放入数独中
     *         2.检查行列，九宫格是否有重复的，有则选择下一个元素检查，重复2
     *         3.直到遍历完所有board[i][j]
     * */


    /**
     * 时间复杂度：O(mn) mn为数独棋盘行和列
     * 空间复杂度O(1)
     * */

    /**
     * 算法描述：
     *          1.验证数独中某个格子该不该填某个数，遍历九宫格，行和列
     *          2.在solveSudokuHelper方法中递归寻找问题的解，如果数独没有解则会返回false，不会无限递归
     *
     * */
    /**
     * 讨论和总结：
     *           1.在leetcode_36中学到了如何遍历九宫格和每一行，每一列
     *           2.用递归求解数独的有效解
     * */
    public static void main(String[] args) {
        String name = "黄威朝"; // TODO 改成你自己的名字
        SudokuSolution sln = new SudokuSolution();
        System.out.println("====== " + name + "的题解作业5（回溯法）：测试开始 ======\n");


        int[][] board = new int[][] {new int[] {5,3,0,0,7,0,0,0,0},new int[] {6,0,0,1,9,5,0,0,0},new int[] {0,9,8,0,0,0,0,6,0},new int[] {8,0,0,0,6,0,0,0,3},new int[] {4,0,0,8,0,3,0,0,1},new int[] {7,0,0,0,2,0,0,0,6},new int[] {0,6,0,0,0,0,2,8,0},new int[] {0,0,0,4,1,9,0,0,5},new int[] {0,0,0,0,8,0,0,7,9}};
        sln.solveSudoku(board);

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
