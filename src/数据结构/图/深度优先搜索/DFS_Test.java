package 数据结构.图.深度优先搜索;

public class DFS_Test {

    int goal_x = 9, goal_y = 9;     //目标的坐标，暂时设置为右下角
    int n = 10 , m = 10;               //地图的宽高，设置为10 * 10的表格
    int graph[][]=new int [n][m];        //地图
    int used[][]=new int[n][m];         //用来标记地图上那些点是走过的
    int px[] = {-1, 0, 1, 0};       //通过px 和 py数组来实现左下右上的移动顺序
    int py[] = {0, -1, 0, 1};
    boolean flag = false;           //是否能达到终点的标志


    void DFS(int graph[][], int used[][], int x, int y)
    {

        // 如果与目标坐标相同，则成功
        if (graph[x][y] == graph[goal_x][goal_y]) {
            System.out.println("successful");
            flag = true;
            return ;
        }
        // 遍历四个方向
        for (int i = 0; i != 4; ++i) {
            //如果没有走过这个格子
            int new_x = x + px[i], new_y = y + py[i];
            if (new_x >= 0 && new_x < n && new_y >= 0
                    && new_y < m && used[new_x][new_y] == 0 && !flag) {

                used[new_x][new_y] = 1;     //将该格子设为走过

                DFS(graph, used, new_x, new_y);      //递归下去

                used[new_x][new_y] = 0;//状态回溯，退回来，将格子设置为未走过
            }
        }
    }
    public static void main(String[] args) {
        int graph[][]=new int [10][10];        //地图
        int used[][]=new int[10][10];         //用来标记地图上那些点是走过的
       new DFS_Test().DFS(graph,used,0,1);
    }
}
