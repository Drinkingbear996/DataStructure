package 算法.二分查找;
public class 查找最后一个值等于给定值的元素 {
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                /**
                 * 如果 a[mid]这个元素已经是数组中的最后一个元素了，那它肯定是我们要找的；
                 * 如果 a[mid]的后一个元素 a[mid+1]不等于 value，那也说明 a[mid]就是我们要找的最后一个值等于给定值的元素。
                 *
                 * */
                if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
