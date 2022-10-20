package 算法.动态规划;

/**
 *动态规划问题的解法
 * 1、创建问题和子问题
 * 2、创建备忘录数组
 * 3、查表+填表



 解法：每次迭代从其中取出

 *          h[i]+d[i-2] h是迭代数组
 *  max {
 *          d[i-1]  d是备忘录数组

 * */
public class leetcode198_打家劫舍 {

    public  int rob(int[] nums) {
        int d[]=new int[nums.length];

        if (nums.length>=1)
        {
            d[0]=nums[0];
        }

        if(nums.length>=2)
        {
            d[1]=Math.max(nums[0],nums[1]);
        }


        for (int i = 2; i < nums.length; i++) {
            d[i]=Math.max(d[i-1],nums[i]+d[i-2]);
        }


        return  d[nums.length-1];


    }
}
