package 技巧.快慢指针;

public class leetcode485_最大连续1的个数 {
    //初始为 0 1 前后快慢指针，一次做出

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxlen=0;
        int len=0;
        int length=nums.length;
        int fast=1,slow=0;

      while (true)
      {


          if (nums[slow]==1)
          {
              len++;
          }

          if (slow==length-1)
          {
              maxlen=Math.max(len,maxlen);
              break;
          }

          if (nums[fast]!=1)
          {
              maxlen=Math.max(len,maxlen);

              len=0;
          }
          fast++;
          slow++;


      }
      return maxlen;
    }

    public static void main(String[] args) {
        int a[]=new int[]{1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(a));
    }
}
