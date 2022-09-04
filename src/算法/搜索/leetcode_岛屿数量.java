package 算法.搜索;

public class leetcode_岛屿数量 {


    public static void main(String[] args) {

    }
}
class Solution {

  int dx[]= {0,0,-1,1};
  int dy[]= {-1,1,0,0};
    int lenx, leny;
   public int numIslands(char[][] grid) {
      lenx =grid.length;
      leny =grid[0].length;

        int count=0;

        for(int i=0;i<lenx;i++)
        {
            for(int j=0;j<leny;j++)
            {
                if (grid[i][j]=='1')
                {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }


  void  dfs(char [][] grid,int x,int y)
    {
        if (x<0||x>lenx-1||y<0||y>leny-1||grid[x][y]=='0')
            return ;

        grid[x][y]='0';

        for(int i=0;i<4;i++)
        {
            dfs(grid,x+dx[i],y+dy[i]);
        }
    }

    public static void main(String[] args) {

    }
}
