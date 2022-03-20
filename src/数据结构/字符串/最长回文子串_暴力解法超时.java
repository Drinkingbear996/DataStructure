package 数据结构.字符串;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * */
public class 最长回文子串_暴力解法超时 {

        public boolean ishuiwen(String s)
        {
            int len=s.length();
            for (int i=0;i<len/2;i++)
            {
                if (s.charAt(i)!=s.charAt(len-1-i))
                    return  false;
            }

            return true;
        }

    public  String longestPalindrome(String s) {

            int maxlen=0;
            String res="";
            int slen=s.length();
        for (int i = 0; i < slen; i++) {
            for (int j = i+1; j <=slen ; j++) {
                String temp=s.substring(i,j);
                int len=temp.length();
                if (ishuiwen(temp)&&len>maxlen)
                {
                    res=temp;
                    maxlen=len;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 最长回文子串_暴力解法超时().longestPalindrome("aacabdkacaa"));

    }
}
