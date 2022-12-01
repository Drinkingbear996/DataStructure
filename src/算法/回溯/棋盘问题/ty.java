package 算法.回溯.棋盘问题;

public class ty {
    public String tictactoe(int[][] moves) {
        int m=moves.length;
        //0-2 表示0-2行 3-5， 表示0-2列 ，6左对角线 ，7右对角线
        int [] count=new int[8];

        for(int i=m - 1; i>=0;i-=2){

            //拿出x，y坐标
            int x=moves[i][0];
            int y=moves[i][1];
            //对行的影响
            count[x]++;
            //对列的影响
            count[y+3]++;
            //左对角线
            if (x==y){
                count[6]++;
            }
            //右对角线
            if (x+y==2){
                 count[7]++;
            }
            if (count[x]==3 || count[y+3]==3 || count[6]==3 || count[7]==3 ){
                return m%2==0 ? "B" :"A";
            }

        }
        if (moves.length<9){
            return  "Pending";
        }
        return "Draw";

    }
}
