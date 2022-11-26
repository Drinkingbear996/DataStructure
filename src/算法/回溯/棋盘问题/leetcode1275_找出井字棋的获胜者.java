package 算法.回溯.棋盘问题;

import java.util.ArrayList;
import java.util.List;

public class leetcode1275_找出井字棋的获胜者 {

    public String tictactoe(int[][] moves) {
        //A和B分开判断，1个棋盘只放A/B
        List<int[]> A=new ArrayList<>();
        List<int[]> B=new ArrayList<>();
        boolean Awin=false,Bwin=false;
        for (int i = 0; i <moves.length ; i+=2) {
            A.add(moves[i]);
            if(i+1<moves.length)
                B.add(moves[i+1]);
        }
        for (int i = 0; i <A.size() ; i++) {
            for (int j = i+1; j <A.size() ; j++) {
                for (int k = j+1; k <A.size() ; k++) {
                    if((A.get(i)[0]==A.get(j)[0]&&A.get(j)[0]==A.get(k)[0])|| //横着连三个
                            A.get(i)[1]==A.get(j)[1]&&A.get(j)[1]==A.get(k)[1]||//竖着连三个
                            A.get(i)[1]+A.get(i)[0]==2&&A.get(j)[1]+A.get(j)[0]==2 &&A.get(k)[0]+A.get(k)[1]==2|| //反斜对角线
                            A.get(i)[1]==A.get(i)[0]&&A.get(j)[1]==A.get(j)[0]&&A.get(k)[0]==A.get(k)[1]){ //正斜对角线
                        Awin=true;
                        return "A";
                    }
                }
            }
        }
        for (int i = 0; i <B.size() ; i++) {
            for (int j = i+1; j <B.size() ; j++) {
                for (int k = j+1; k <B.size() ; k++) {
                    if((B.get(i)[0]==B.get(j)[0]&&B.get(j)[0]==B.get(k)[0])||
                            (B.get(i)[1]==B.get(j)[1]&&B.get(j)[1]==B.get(k)[1])||
                            B.get(i)[0]+B.get(i)[1]==2&&B.get(j)[0]+B.get(j)[1]==2&& B.get(k)[1]+B.get(k)[0]==2||
                            B.get(i)[0]==B.get(i)[1]&&B.get(j)[0]==B.get(j)[1]&& B.get(k)[1]==B.get(k)[0]
                    ){
                        Bwin=true;
                        return "B";
                    }
                }
            }
        }
        if(moves.length<9&&!Awin&&!Bwin){
            return "Pending";
        }else {
            return "Draw";
        }
    }


}
