package 技巧.快慢指针;

/**
 *快慢指针思想：
 * 快慢指针开始时都位于0的位置，如果快指针符合某个条件，慢指针的下一个元素=快指针当前元素的值
 * 第一次遍历：将非0数放在左边，并且记录0的个数
 * 第二次遍历：将末尾的元素安装个数一一赋值为0；
 * */
public class leetcode283_移动零 {

    class Solution {
        public void moveZeroes(int[] nums) {
            if(nums==null) {
                return;
            }
            //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
            int j = 0;
            for(int i=0;i<nums.length;++i) {
                if(nums[i]!=0) {
                    nums[j++] = nums[i];
                }
            }
            //非0元素统计完了，剩下的都是0了
            //所以第二次遍历把末尾的元素都赋为0即可
            for(int i=j;i<nums.length;++i) {
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {

    }
}
