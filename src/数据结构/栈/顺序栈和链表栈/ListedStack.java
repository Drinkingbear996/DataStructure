package 数据结构.栈.顺序栈和链表栈;

import java.net.Inet4Address;
import java.util.Deque;
import java.util.LinkedList;
import java.lang.Integer.*;
import java.util.Stack;


public class ListedStack<T>  {

    public static int test(String [] ops)
    {

        Stack<Integer> stack1=new Stack<>();
        int result=0;

        int count=0;
        for (int i = 0; i < ops.length; i++) {

            if (ops[i].equals("+"))
            {

                int a=stack1.pop();
                int b=stack1.pop();

                result=a+b;
                stack1.push(b);
                stack1.push(a);
                stack1.push(result);
                result=0;
            }

            else if(ops[i]=="D")
            {
                if (!stack1.isEmpty())
                {
                    result= stack1.peek();
                    result*=2;
                    stack1.push(result);
                    result=0;
                }

            }

            else if(ops[i]=="C")
            {

                    stack1.pop();
            }

            else
            {
                stack1.push(Integer.parseInt(ops[i]));
            }
        }

        while(!stack1.isEmpty())
        {
            count+=stack1.pop();
        }


     return count;
    }
   

    public static void main(String[] args) {
        String[] ops=new String[]{"5","-2","4","C","D","9","+","+"};

        System.out.println(test(ops));



    }


}
