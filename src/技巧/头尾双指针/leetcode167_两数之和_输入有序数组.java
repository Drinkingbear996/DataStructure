package 技巧.头尾双指针;

public class leetcode167_两数之和_输入有序数组 {
    /**
     * 头尾双指针
     * 头尾指针值相加，比目标值大，尾部指针向前移动，比目标值小，头指针往前移动
     * */
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while(i<j)
        {

            int sum = numbers[i] + numbers[j];
            if (sum == target)
                return new int[] {i + 1, j + 1};

            else if (sum > target)
                j--;
            else
                i++;
        }
        return null;
    }

    public static void main(String[] args) {

      int a[]=new int[]{2,3,4};
      int newa[]=  twoSum(a,6);
    }
}
