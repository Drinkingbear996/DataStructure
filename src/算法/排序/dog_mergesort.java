package 算法.排序;

public class dog_mergesort {

    // 合并
    static void merge(Dog dogs[], Dog tempArr[], int left, int mid, int right)
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
            if (dogs[l_pos].getAge() < dogs[r_pos].getAge())  // 左半区第一个剩余元素更小
                tempArr[pos++] = dogs[l_pos++];
            else  // 右半区第一个剩余元素更小
                tempArr[pos++] = dogs[r_pos++];
        }

        // 合并左半区剩余的元素
        while (l_pos <= mid)
            tempArr[pos++] = dogs[l_pos++];

        // 合并右半区剩余的元素
        while (r_pos <= right)
            tempArr[pos++] = dogs[r_pos++];

        // 把临时数组中合并后的元素复制回原来的数组
        while (left <= right)
        {
            dogs[left] = tempArr[left];
            left++;
        }
    }

    static void msort(Dog arr[], Dog tempArr[], int left, int right)
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


   static Dog[] init(Dog []dogs)
    {
        Dog[] tempArr=new Dog[dogs.length];
        msort(dogs,tempArr,0,dogs.length-1);
        return  dogs;
    }

    public static void main(String[] args) {
        Dog dogs[]=new Dog[10];
        for (int i = 0; i < 10; i++) {
            dogs[i]=new Dog("测试"+i,(int)(Math.random()*100+1));
        }

        Dog[] tempArr=new Dog[10];
        msort(dogs,tempArr,0,9);


        Dog []dd=init(dogs);
        for (int i = 0; i < dd.length; i++) {
            System.out.println(dogs[i]);
        }
    }
}
