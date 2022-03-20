package 数据结构.字符串;

public class 翻转字符串中的单词3 {

    public static String reverseWords(String s) {
        String x[]=s.split(" ");

        String res="";

        for (int i = 0; i < x.length; i++) {
           char ch[]=x[i].toCharArray();

            int temp2=ch.length-1;

            for (int j=0;j<ch.length/2;j++)
            {
                char c1=ch[j];
                ch[j]=ch[temp2-j];
                ch[temp2]=c1;
            }
            if (i!=x.length-1)
            {
                res+=x[i]+" ";
            }
            else
            {
                res+=x[i];
            }



        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
