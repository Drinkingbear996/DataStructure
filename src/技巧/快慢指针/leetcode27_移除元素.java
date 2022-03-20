package 技巧.快慢指针;

public class leetcode27_移除元素 {
    /**
     * 思路：快慢指针的运用，快慢指针初始值都在0位置
          初始化一个快指针 fast 和一个慢指针 slow，fast 每次移动一步，而 slow 只当 fast 指向的值不等于 val 时才移动一步。

     * 重点：一开始慢指针先动
     *
    题解： https://leetcode-cn.com/leetbook/read/array-and-string/cv3bv/
     * */

    public static int removeElement(int[] nums, int val) {

        int slow=0;
        int len=nums.length;

        for (int fast = 0; fast < len; fast++) {

            if (nums[fast]!=val) {

                nums[slow] = nums[fast];
                slow++;


            }
        }


        return  slow;
    }

    public static void main(String[] args) {
        int sums[]=new int[]{0,1,2,2,3,0,4,2};
      int len=  removeElement(sums,2);
        for (int i = 0; i <len  ; i++) {
            System.out.println(sums[i]);
        }
    }
}
