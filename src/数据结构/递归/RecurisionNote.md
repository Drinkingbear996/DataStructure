# 判断是否为2的幂

给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。

如果存在一个整数 x 使得n == 2 ^x ，则认为 n 是 2 的幂次方。

[comment]: <> (思路)
输入n
判断是否为空，是否为1或它本身。
核心判断：奇数一定不是2的幂次方，递归方法(n/2)

```java
class Solution {
    public boolean isPowerOfTwo(int n) {

	    if(n==0)
        {
            return false;
        }

		if(n==1||n==2) {
		   return true ;
		}
        if(n%2!=0){
        //奇数一定不是2的幂。
            return false;
        }

        else{
        return  isPowerOfTwo(n/2) ;
        }
        
}

    
}
```

-------------------------------------------------------------------------

#反转字符数组

 要求：不要给另外的数组分配额外的空间

[comment]: <> (思路)

双指针，一个从头部开始，一个从尾部开始

while(left<=right)
指针向一步步中间靠拢，头尾挨个交换

```java
class Solution {

    public void reverseString(char[] s) {
//定义两个指针，从头和尾同时往中间走
        int left=0,right=s.length-1;

        while(left<=right)
        {
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;

            left++;
            right--;
        }

    }
}
```

-------------------------------------------------------------------------

