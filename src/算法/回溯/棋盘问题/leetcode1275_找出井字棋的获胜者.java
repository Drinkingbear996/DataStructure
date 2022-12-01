package 算法.回溯.棋盘问题;

import java.util.ArrayList;
import java.util.List;

public class leetcode1275_找出井字棋的获胜者 {
/**
 思路：（可直接看代码，代码有详细注释）

 1、虽然有A、B、Pending、Draw四种答案的可能。我们首先判断A、B谁能赢，再讨论A、B都未胜的情况下游戏是结束了还是继续进行；
 2、判断A、B是否有人能取胜，只需要判断最后一个落棋的人是否能胜；（因为要是另外一个人赢了，游戏就结束了，不再有继续下棋的机会）
 3、用数组记录最后落棋者的走棋情况，如果等于三，游戏结束，此人胜利；（以3x3为例，其余可以类推）
 4、最后落棋者为未胜时，棋盘被下满则Draw，棋盘未下满则Pending。
 * */
//定义moves[][]，数组中有N个长度为2的数组对象，[x,y]表示坐标，如[2,2]
    public static String tictactoe(int[][] moves) {
        int m = moves.length;
        // 用数组记录0-2行、0-2列、正对角线、副对角线是否已满3个棋子
        // count[0-2]对应0-2行、count[3-5]对应0-2列、count[6]对应正对角线、count[7]对应副对角线
        int[] count = new int[8];
        // 思路第2步已解释为何只需考虑最后一个落棋的人
        // 倒序统计此人走棋情况
        // 为什么i-=2 假设A -> B ->A ->B ->A
        //           或者 A-> B -> A ->B ->A ->B，输赢取决于最后一个下棋的人，遍历他下的棋子
        //所以每1步-2
        for(int i = m - 1; i >= 0; i -= 2) {
            //拿出x，y坐标，如（2,2）
            int x=moves[i][0];
            int y= moves[i][1];
            // 此棋对行的影响
            count[x]++;
            // 此棋对列的影响
            count[y + 3]++;
            // 此棋对正对角线的影响
            if(x == y)
                count[6]++;
            // 此棋对副对角线的影响 (此处为3x3的情况，其余大小的棋盘可以类推)
            if(x + y ==  2)
                count[7]++;
            // 满3个棋子则胜利
            if(count[x] == 3 ||
               count[y + 3] == 3 ||
               count[6] == 3 ||
               count[7] == 3)

                // A先B后 则总长度为偶时 最后为B 反之为A
                return m % 2 == 0 ? "B" : "A";
        }
        // 未胜时，棋盘未下满则继续
        if(moves.length < 9)
            return "Pending";
        // 未胜时，棋盘下满则平局结束
        return "Draw";
    }

    public static void main(String[] args) {
        int []moves[]=new int[9][1];
        moves[0]=new int[]{0,0};
        moves[1]=new int[]{1,1};
        moves[2]=new int[]{2,0};
        moves[3]=new int[]{1,0};
        moves[4]=new int[]{1,2};
        moves[5]=new int[]{2,1};
        moves[6]=new int[]{0,1};
        moves[7]=new int[]{0,2};
        moves[8]=new int[]{2,2};
        //应当返回Draw平局
        System.out.println(tictactoe(moves));
    }


}
