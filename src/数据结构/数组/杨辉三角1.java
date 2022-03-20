package 数据结构.数组;
import java.util.LinkedList;
import java.util.List;
/**
 * 杨辉三角形 返回杨辉三角形的前n行
 * 特殊情况：三角形的每一行的头尾都设定为 1
 * 其他情况：其他元素:
 *              如第 i 行元素的第 j 个值 = 第 i-1 行的第 j-1 个值 + 第 i-1 行的第 j 个值
 * */

//自己写出来，但花了些时间。
public class 杨辉三角1 {
    public static List<List<Integer>> generate(int numRows) {


        List<List<Integer>> a=new LinkedList<>();

        for (int i = 0; i <=numRows; i++) {
            List<Integer> x=new LinkedList<>();
            for (int j = 0; j < i; j++) {
                //特殊情况
                if (j==0||j==i-1)
                {
                    x.add(1);
                }
                //基本情况
                else
                {
                    List<Integer> b=a.get(i-2);
                    int o=b.get(j-1);
                    int p=b.get(j);
                    x.add(o+p);
                }

            }
            a.add(x);

        }
        return  a;

    }

    public static void main(String[] args) {
        generate(5);
    }

}
