package 算法.二分查找;

//二分查找针对的是一个有序的数据集合
/**
*二分查找针对的是一个有序的数据集合，查找思想有点类似分治思想。每次都通过跟区间的中间元素对比，将待查找的区间缩小为之前的一半，直到找到要查找的元素，或者区间被缩小为 0。
*局限性：有序，数据结构.数组，数据量大，数据量小遍历和二分差不多
*复杂度log2(n)
*/


public class 查找值等于给定值的元素 {
//利用二分查找在有序数组中找某个数

    public static int bsearch(int[] a, int n, int value) {
        //定义最小索引
        int low = 0;
        //定义最大索引
        int high = n - 1;

        //用中间值来找对应的数的坐标
        while (low <= high) {
            int mid = (low + high) / 2;
            //如果中间值等于target
            if (a[mid] == value) {
                return mid;
            //如果中间值小于目标
            } else if (a[mid] < value) {
                //因此target对应值的坐标范围为中间值以上，所以最低边界为a[mid]+1
                low = mid + 1;
            }
            //如果中间值大于目标
            //因此target对应值的坐标范围为中间值以下，所以最高边界为a[mid]-1
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        //问题：找33需要几次？
        int a[]={8,11,19,23,27,33,45,55,67,98};
        System.out.println(bsearch(a,a.length,33));
    }
}
