package 数据结构.字符串;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-fa-he-dong-tai-gui-hua-by-reedfa/
 * 中心扩散法
 * */
public class 最长回文子串_中心扩散法 {

    /**
     * 思路如下
     *
     * */

    public static String longestPalindrome1(String s) {
        if (s==null ||s.length()==0){
            return "";
        }

        //获取字符串长度 用于循环
        int length = s.length();

        //  //变量存储 i的下标
        int left=0;
        int right=0;
        // 最大长度,只有一个时为1 ，所以初始值为1；
        int maxlen=0;
        //获取切割字段的 起始位置
        int maxStart=0;
        for (int i =0 ; i<length;i++){
            //记录循环长度 ,自动刷新
            int len =1;
            //获取当前位置的左右位置的下标
            left = i-1;
            right= i+1;

            //左扩散
            while (left>=0 && s.charAt(left)==s.charAt(i)){
                len++;
                left--;
            }
            //右扩散  最后一位也算入
            while (right<length && s.charAt(right)==s.charAt(i)){
                len++;
                right++;
            }
            //左右扩散 ,左边的值等于右边
            while (right<length && left>=0  && s.charAt(right)==s.charAt(left)){
                len+=2;
                right++;
                left--;
            }
            if (len>maxlen){
                maxlen=len;
                //因为每完成一次 ，left--，所以最后合格的一次也--，导致开始位置向后移动一位
                maxStart = left+1;
            }
        }
        return s.substring(maxStart,maxlen+maxStart);
    }


//根据记忆编写，✅
public String huiwen(String s)
{
    if (s.length()<=0||s==null)
    {
        return "";
    }
    int strlen=s.length();
    int left=0;
    int right=0;
    int maxlen=0;
    int len=0;
    int maxStart=0;

    for (int i=0;i<strlen;i++)
    {
        //重置
        len=1;

        left=i-1;
        right=i+1;

        while (left>=0 && s.charAt(i)==s.charAt(left))
        {
            left--;
            len++;

        }
        while(right<strlen && s.charAt(i)==s.charAt(right) )
        {
            right++;
            len++;
        }
        while (left>=0 && right<strlen && s.charAt(left)==s.charAt(right) )
        {
            len+=2;
            left--;
            right++;
        }
        if (len>maxlen)
        {
            maxlen=len;
            maxStart=left+1;
        }

    }
    return s.substring(maxStart,maxlen+maxStart);
}





    public static void main(String[] args) {
        System.out.println(longestPalindrome1("acdbbdaa"));
    }
}
