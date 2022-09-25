
#二分查找

###套路
 1. 从一个严格升序的数组中查找某一个元素（无重复）
 2. 从一个严格升序的数组中查找某一个元素（重复）
    下界 ： 找数组 <= TARGET 的第1个元素
    上界 ： 找数组 >= TARGET 的最后一个元素

### 二分查找只有上界和下界，常规这三种


Question: 寻找某个target的值
                    优点：寻找到某一个target值就返回
                    缺点：不知道有多少个target值

###常规
```java
class Solution {
    public int search(int[] nums, int target) {

        int left=0,  right=nums.length - 1;
        
        while(left<=right)
        {
            int mid =(left+right)/2;
            int num= nums[mid];
            if(num==target)
                return mid;

            if(num<target)
                left=mid+1;
            else
                right=mid -1;
        }
        return -1;
    }
}
```

    Question：在一个升序数组中，缺失某个值，标出它应该插入的位置
###上界模版
        找数组中>=target的最后1个元素
        
```java
class Solution
{
    static int upBoundarySearch  (int nums[],int target) {

        int left=0,right=nums.length-1;
        
        while(left<right)
        {
            int mid=(left+right+1)/2;
            if(nums[mid]>target)
              right=mid-1;
            else
                left=mid;

            if(nums[left]==target)
                return left;
        }
        return -1;
    }
}
```

###下界模版
            找数组中<=target的第1个元素
```java
class solution
{
    static int lowerBoundary (int nums[],int target)
    {
        int left=0,right=nums.length-1;
        while(left<right)
        {
            int mid=(left+right)/2;
            if(nums[mid]<target)
                left=mid +1; // 找数组中<=target的第1个元素
            else 
                right=mid;
        }
        return left;
    }
}

```