package 算法.二分查找;

public class test {
    static int upBoundarySearch  (int nums[],int target)
    {
        int left=0,right=nums.length-1;

        while(left<right)
        {
            int mid=(left+right+1)/2; //取中点和右边

            if (nums[mid]>target)
                right=mid-1;         // 找数组中>=target的第1个元素
            else
                left=mid;
        }
        System.out.println("上界是"+left);
        System.out.println("下界是"+right);
        System.out.println("Target的个数="+(left-right+1));
        return  left;
    }

    public static void main(String[] args) {
        int a[]=new int[]{1,2,3,3,3,4,5,6};
        upBoundarySearch(a,4);
    }
}
