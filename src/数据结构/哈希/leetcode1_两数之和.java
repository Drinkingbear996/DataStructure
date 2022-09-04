package 数据结构.哈希;

import java.util.HashMap;

/**
 *
 * 当我们需要查询一个元素是否出现过，或者一个元素是否在集合里的时候
 * 就要第一时间想到哈希法。
 * */
public class leetcode1_两数之和 {
}

// 法一：哈希法
class Solution {
    public int[] twoSum(int[] nums, int target) {

        int res []=new int [2];
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int temp=target-nums[i];
            if (map.containsKey(temp))
            {
                res[0]=map.get(temp);
                res[1]=i;
            }

            map.put(nums[i],i);

        }
        return  res;
    }
}

//法二 ： 双重for
class Solution1 {
    public int[] twoSum(int[] nums, int target) {

        int res []=new int [2];


        for (int i = 0; i < nums.length; i++) {

            int temp=target-nums[i];

            for(int j=i+1;j < nums.length;j++)
            {
                if (temp==nums[j])
                {
                    res[0]=i;
                    res[1]=j;
                }
            }

        }
        return  res;
    }
}
