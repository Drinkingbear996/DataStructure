package 算法.动态规划;

public class Solution {

/**
 *动态规划问题的解法
 * 1、创建问题和子问题
 * 2、创建备忘录数组
 * 3、查表+填表
 * 70、198（对标实验3）、300题
 *         h[i]+d[i-2] h是迭代数组
 *  max {
 *          d[i-1]  d是备忘录数组
 *
 *
 * 预习 1143 背包问题
 * */

 public static int rob(int[] nums) {
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
            System.out.println(d[i]);
        }


    return  d[nums.length-1];


}

    public static void main(String[] args) {
     int a[]=new int[]{2,7,9,3,1};
     rob(a);
    }

}