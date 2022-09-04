package 算法;

public class Solution {

    //双指针

    public int openLock(String[] deadends, String target) {


        int len=deadends.length;
        String start="0000";
        int head=0,tail=9;

        while (true)
        {
            if (head>tail)
            {

            }

            head++;
            tail--;
            int a=Integer.valueOf(start)+1;
            start=a+"%04d";

            int b=Integer.valueOf(start);
            start=b+"";


        }

    }
}
