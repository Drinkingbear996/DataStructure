package 算法.排序;

/**
 * 1.将数组分为等长若干组
 * 2.每两组之间进行排序，比较他们的头部，从小到大放入新序列。
 *   当某一组为空时，将另一组全部合并到新序列。
 * 3.重复第2步操作，直到只剩下1组序列
 * */
@SuppressWarnings("all")
public class MergeSort {

    // 合并
   static void merge(int arr[], int tempArr[], int left, int mid, int right)
    {
        // 标记左半区第一个未排序的元素
        int l_pos = left;
        // 标记右半区第一个未排序的元素
        int r_pos = mid + 1;
        // 临时数组元素的下标
        int pos = left;

        // 合并
        while (l_pos <= mid && r_pos <= right)
        {
            if (arr[l_pos] < arr[r_pos])  // 左半区第一个剩余元素更小
                tempArr[pos++] = arr[l_pos++];
            else  // 右半区第一个剩余元素更小
                tempArr[pos++] = arr[r_pos++];
        }

        // 合并左半区剩余的元素
        while (l_pos <= mid)
            tempArr[pos++] = arr[l_pos++];

        // 合并右半区剩余的元素
        while (r_pos <= right)
            tempArr[pos++] = arr[r_pos++];

        // 把临时数组中合并后的元素复制回原来的数组
        while (left <= right)
        {
            arr[left] = tempArr[left];
            left++;
        }
    }

    // 归并排序
   static void msort(int arr[], int tempArr[], int left, int right)
    {
        // 如果只有一个元素，那么不需要继续划分
        // 只有一个元素的区域，本生就是有序的，只需要被归并即可
        if (left < right)
        {
            // 找中间点
            int mid = (left + right) / 2;
            // 递归划分左半区
            msort(arr, tempArr, left, mid);
            // 递归划分右半区
            msort(arr, tempArr, mid + 1, right);
            // 合并已经排序的部分
            merge(arr, tempArr, left, mid, right);
        }
    }




    public static void main(String[] args) {

        int arr[]={2,343,546,22,43,1,0,54,32};

        int n= arr.length;

        //创建临时数组放入排序后的变量
        int[] tempArr=new int[n];
        msort(arr,tempArr,0,n-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
