package 技巧.快慢指针;

import java.util.*;

/**
 * Java可以用Set集合来解
 * 快慢指针解法
 * 升序情况下
 * 当fast对应的值！=slow,slow+1对应的值与fast对应的值交换，继续遍历。
 * */
public class leetcode26_删除排序数组中的重复项 {
    public static int removeDuplicates(int[] nums) {

      int slow=0;
      int len=nums.length;
      for(int fast=1;fast<len;fast++)
      {
          if (nums[slow]!=nums[fast])
          {
              slow++;
              nums[slow]=nums[fast];
          }
      }
      //当slow移动n次时，实际上有n+1个数字
      return slow+1;
    }

    public static void main(String[] args) {
        int a[]=new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(a));
    }
}
