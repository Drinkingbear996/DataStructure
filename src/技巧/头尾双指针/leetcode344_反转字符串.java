package 技巧.头尾双指针;


public class leetcode344_反转字符串 {
    public void reverseString(char[] s) {

        int temp1=0;
        int temp2=s.length-1;
        char con=' ';

        for (int i = 0; i < s.length/2; i++) {

            con= s[temp1];
            s[temp1]=s[temp2];
            s[temp2]=con;
            temp1++;
            temp2--;
        }

    }

}
