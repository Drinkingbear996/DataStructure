package 数据结构.字符串;
/**
 *
 *编写一个函数来查找字符串数组中的最长公共前缀。
 *如果不存在公共前缀，返回空字符串 ""。
 *
 *思路：最长前缀字符串取决于最小长度的字符串
 * 找最长从最后开始，最短从前面开始
 *
 * API：
 * 返回字符串第一次出现的索引 str.indexOf(str)
 * 切割字符串，左闭右开 str.substring(0, minStr.length()-1);
 * */
public class 最长公共前缀 {

    public static String longestCommonPrefix(String[] strs) {

        String res;
        //定义首个字符串为最小值
        String minStr = strs[0];

        //公共前缀取决于最小的字符串，所以找出长度最小的字符串

        for(int i=1;i<strs.length;i++){
            if(strs[i].length()<minStr.length()){
                minStr = strs[i];
            }
        }

        //计数器，计算相同前缀的个数
        int count = 0;
        for(int i=0;i<minStr.length();i++){

            //因为题目要最长嘛，从最大的开始，逐渐减少字符串的长度，符合的就返回
            res = minStr.substring(0, minStr.length()-i);

            count = 0;
            for(int j=0;j<strs.length;j++){
                //返回字符串第一次出现的索引，如果为0就++,否则不变。
              count=  strs[j].indexOf(res)==0 ? count=count+1:count;

            }
            //如果count等于strs[]的长度，则证明是公共子串
            if(count==strs.length){
                return res;
            }
        }
        //如果没一个符合的，返回空。
        return "";


    }

    public static void main(String[] args) {
    String strs []= new String[]{"flower","flow","flight"};

        System.out.println( longestCommonPrefix(strs));
    }

}
