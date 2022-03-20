package 数据结构.数组;

import java.util.LinkedList;
import java.util.List;

public class 杨辉三角2 {
    public static List<Integer> getRow(int rowIndex) {

        List< List<Integer>> l=new LinkedList<>();



        for(int i=0;i<=rowIndex;i++)
        {
            List<Integer>   a=new LinkedList<>();
            for (int j = 0; j <=i ; j++)
            {
                if (j==0||j==i)
                {
                    a.add(1);

                }
                else
                {
                    List<Integer>  b=l.get(i-1);
                    int o=b.get(j-1);
                    int p=b.get(j);
                    a.add(o+p);
                }
            }
            l.add(a);


        }
        return l.get(rowIndex);
    }

    public static void main(String[] args) {
        getRow(3);
    }
}
