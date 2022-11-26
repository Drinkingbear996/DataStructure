package 算法;

import java.util.HashMap;

public class Solution {
    /**
     * 两数之和，在数组中找到两个数，使得它们的和等于target，返回这两个数的下标（存于数组中返回）
     */
    public int[] twoSum(int[] nums, int target) {
        int index1 = -1, index2 = -1; // 可将答案1和答案2存在这两个变量中

        /*********** 请设计算法并补全代码 ***************/

      HashMap<Integer,Integer> map=new HashMap<>();

      //通过循环，必会经过这两个目标值
        for (int i = 0; i < nums.length; i++) {


            int cur=nums[i];
            //作差 若target=9，2匹配7 7匹配2
            int temp=target-cur;

            if(map.containsKey(temp))
            {
                index1=i;
                index2=map.get(temp);
            }
            //否则不断地放进去
            map.put(cur,i);
        }

        /**********************************************/

        int[] ans = { index1, index2 };
        return ans;
    }
}

