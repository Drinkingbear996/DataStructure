//package 数据结构.栈;
//
//import 数据结构.队列.ArrayQueue;
//
//import java.util.ArrayDeque;
//import java.util.Deque;
//import java.util.HashMap;
//import java.util.Map;
//
//public class Calculator {
//    Map<Character,Integer> map=new HashMap<>();
//
//    {
//        map.put('-',1);
//        map.put('+',1);
//        map.put('*',2);
//        map.put('/',2);
//        map.put('%',2);
//        map.put('^',3);
//    }
//
//    public int calculate(String s)
//    {
//        //去掉所有空格
//        s=s.replace(" ","");
//        char cs[]=s.toCharArray();
//        int n=s.length();
//
//        //存放所有数字
//        Deque<Integer> nums=new ArrayDeque<>();
//        nums.addLast(0);
//        //存放所有非数字以外的操作
//
//        Deque<Character> ops=new ArrayDeque<>();
//        for (int i = 0; i < n; i++) {
//             char c=cs[i];
//
//             if (c=='(')
//             {
//                 ops.addLast(c);
//             }
//             else  if (c==')')
//             {
//                 //计算到最近的一个左括号为止
//                 while(!ops.isEmpty())
//                 {
//                     if (ops.peekLast()!='（')
//                     {
//                         calc(num,ops)
//                     }
//                     else
//                     {
//                         ops.pollLast();
//                         break;
//                     }
//
//                 }
//             }
//             else
//             {
//                 if (isNumber(c))
//                 {
//
//                 }
//             }
//        }
//
//
//    }
//
//}
