package 算法.排序;

public class test {

    static void msort(int left, int right, int arr[], int temparr[]) {
        //两个及两个以上的元素才递归
        if (left < right) {
            int mid = (left + right) / 2;

            //递归左半区
            msort(left, mid, arr, temparr);

            //递归右半区
            msort(mid + 1, right, arr, temparr);

            //合并已经查询的部分
            mmerge(arr, temparr, left, right, mid);

        }


    }

    //合并
    static void mmerge(int arr[], int temparr[], int left, int right, int mid) {
        //左半区第1个元素
        int l_pos=left;
        //右半区第1个元素
        int r_pos=mid+1;
        //临时数组元素的下标
        int pos =left;

        //合并,保证有左右两个半区都有元素
        while(l_pos<=mid && r_pos<=right)
        {
            //左半区第1个元素更小
            if(arr[l_pos]<arr[r_pos])

                temparr[pos++]=arr[l_pos++];
            //右半区第1个元素更小
              else
              temparr[pos++]=  arr[r_pos++];

        }

    //合并左半区剩余的元素
        while(l_pos <= mid)
        {
            temparr[pos++]=arr[l_pos++];

        }
    //合并右半区剩余元素
        while(r_pos<=right)
        {
            temparr[pos++]=arr[r_pos++];
        }
    //把临时数组中合并的元素复制回原来数组
      while(left<=right)
      {
          arr[left]=temparr[left];
          left++;
      }

}



    public static void main(String[] args) {

        int arr[]={2,343,546,22,43,1,0,54,32};
        int n= arr.length;
        int temparr[]=new int[n];
        msort(0,n-1,arr,temparr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
