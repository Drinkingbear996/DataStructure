package 技巧.滑动窗口_求集合最小子集;

import java.util.*;
/**
 * 求集合中元素相加等于某个值的最小子集合---------滑动窗口。
 * 创建一个队列，只要大于目标值就出队，并且每一次都记录符合条件的最小队长。
 *题解：Lhttps://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/javade-jie-fa-ji-bai-liao-9985de-yong-hu-by-sdwwld/
 * */
public class leetcode209_长度最小的子数组 {
    public static int minSubArrayLen(int target, int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        int minlen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {

            //入队
            q.add(nums[i]);

            sum+=nums[i];
            while (sum >= target) {
                minlen = Math.min(minlen, q.size());
                int x=q.poll();
                sum -= x;
            }

        }
        return  minlen==Integer.MAX_VALUE ? 0: minlen;
    }

    public static void main(String[] args) {
        int[] a =new int[]{4,4,1};
        System.out.println(minSubArrayLen(4,a));
    }
}
