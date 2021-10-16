package 数据结构.栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoLanCalculator {


    //将一个逆波兰表达式，依次将数据和运算符放入到ArrayList当中
public static List<String> getListString(String suffixExpression)
{
   String [] split= suffixExpression.split(" ");

   List<String> list=new ArrayList<>();

   for (String i:split)
   {
       list.add(i);

   }

   return list;
}


    public static  int calculate(List<String> ls)
    {

        Stack<String> stack = new Stack<>();

        //遍历ls

        for (String item:ls)
        {
            //使用正则表达式
         if (item.matches("\\d+"))
         {
             //入栈
             stack.push(item);

         }
         else
         {
             //pop出两个数，并运算，再入栈

             int num2= Integer.parseInt(stack.pop());
             int num1= Integer.parseInt(stack.pop());

             int res;

             if (item.equals("+"))
             {
                 res=num1+num2;
             }
             else if (item.equals("-"))
             {
                 res=num1-num2;
             }
             else if (item.equals("*"))
             {
                 res=num1*num2;
             }
             else if (item.equals("/"))
             {
                 res=num1/num2;
             }
             else
             {
                 throw new RuntimeException("运算符有误");
             }
             //入栈
             stack.push(res+"");

         }

        }
        //最后留在stack中的是运算结果
        return Integer.parseInt(stack.pop()) ;
    }


// (3+4)x5-6 ==> 3 4 + 5 x 6 -

    public static void main(String[] args) {

        String suffixExpression="30 4 + 5 * 6 -";

        //1. 先将 3 4 + 5 x 6 -放入ArrayList中
        //2. 给 ArrayList 传递一个方法，遍历

        List<String> list=getListString(suffixExpression);

        System.out.println("list="+list);


        int res=calculate(list);
        System.out.println("计算的结果是="+res);







    }
}
