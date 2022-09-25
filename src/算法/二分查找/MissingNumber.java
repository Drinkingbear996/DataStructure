package 算法.二分查找;

import java.util.Arrays;


class Solution {

    /**
     * 题解作业二 （二分搜索）：
     * 提供一个连续数组，但里面恰好缺失了一个数字，请使用二分搜索找出缺失的数字
     * @param nums 包含了 1 到 n 当中的 (n - 1) 个数字，数组按从小到大排好序，且不存在重复的数字
     * @return 返回 1 到 n 里面 nums 数组缺失的那个数字
     */

    /**
     * 问题描述 ：
     *       nums 包含了 1 到 n 当中的 (n - 1) 个数字，数组按从小到大排好序，且不存在重复的数字
     *       返回 1 到 n 里面 nums 数组缺失的那个数字
     *
     *
     * 解题思路：
     *      如果左边是连续的数组要满足 nums[i]-1=i,所以left=mid，反之左边不连续，right=mid-1
     *
     * 时间复杂度：
     *      log2n
     *
     * 总结：
     *      一开始写想用上界模版，去看了下leetcode268，有了思路，最后写着写着发现有一种情况
     *      离正确答案少2，另一种少1,补上就对了。
     * */


    public int missingNumberBinarySearch(int[] nums) {
        // 初始化
        int n = nums.length + 1, answer = -1;

        // 以下代码使用了数组遍历，时间复杂度仅为O(n)，请设计二分搜索算法并替换以下代码：

        // ------ 计算开始 ------
        int left=0,right=nums.length-1;

      while(left<right)
      {
          int mid=(left+right+1)/2;
          if(mid==nums[mid]-1)
              left=mid; //证明左边都是连续的，否则左边是不连续的
          else
              right=mid -1;
      }

        // ------ 计算结束 ------

        // 返回结果
        return nums[right]-1 != right ? right+1 : right + 2;
    }

    /**
     * [力扣268. 丢失的数字](https://leetcode.cn/problems/missing-number/):
     * 力扣提供的方法入口，如果是在力扣提交则必须包含本方法，本地运行可忽略
     */
    public int missingNumber(int[] nums) {
        // 力扣题目和作业描述有点不一样，这里想利用力扣的测试数据，所以需要做一些转换：

        Arrays.sort(nums);

        int left=0,right=nums.length-1;

        while(left<right)
        {
            int mid = (left+right+1)/2;

            if(nums[mid]==mid)
                left=mid;
            else
                right=mid-1;
        }
        return nums[right]!=right ? right:right+1;
    }

}

public class MissingNumber {
    public static void main(String[] args) {
        String name = "黄威朝"; // TODO 改成你自己的名字
        Solution solution = new Solution();
        System.out.println("====== " + name + "的题解作业二：测试开始 ======\n");

        int[] nums1 = { 1, 2, 3 };
        int ans1 = solution.missingNumberBinarySearch(nums1);
        System.out.println("测试用例1 我的答案: " + ans1 + " 正确答案: 4\n");

        int[] nums2 = { 2, 3, 4, 5, 6 };
        int ans2 = solution.missingNumberBinarySearch(nums2);
        System.out.println("测试用例2我的答案: " + ans2 + " 正确答案: 1\n");

        int[] nums3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 20 };
        int ans3 = solution.missingNumberBinarySearch(nums3);
        System.out.println("测试用例3 我的答案: " + ans3 + " 正确答案: 16\n");

        System.out.println("====== " + name + "的题解作业二：测试结束 ======");




    }
}
