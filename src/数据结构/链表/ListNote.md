
#反转链表思路：
  在链表当中，next是链，是指向，（保证链表不断）
创建指针 暂存节点 反转头

1. 先将所断节点的下一个节点存储起来
2. 所断节点指向 反转节点的指向
3. 反转头指向所断节点
4. 指针移动，移动到（所保存节点）
5. 循环
6. 原头指向=反转头的指向


```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
   public ListNode reverseList(ListNode head) {

//指针
      ListNode temp=head;
//反转头
      ListNode ReverseHead=new ListNode(0);
//暂存
      ListNode tempFornow=null;


      while(temp!=null)
      {

         tempFornow=temp.next;
         temp.next=ReverseHead.next;
         ReverseHead.next=temp;
         temp=tempFornow;
      }

      return ReverseHead.next;

   }
}
```

-------------------------------------------------------------------------


#逆序打印单链表
利用栈，先入后出的特点，输出

-------------------------------------------------------------------------


#请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。

固定思路：遍历链表，找到节点，跳过

解题：
   题目已经给出了要删除节点（非末尾）,直接跳过就好了
 
```java
    //node.val=node.next.val;
    //node.next=node.next.next;
     
```    



-------------------------------------------------------------------------

#合并两个有序的链表
创建一个新链表c，有头结点head，并传值为-1，它的指针为temp3

设链表为a,b
temp1、temp2分别为链表a、b的指针


          [comment]: <> (思路：)
分别遍历a和b两个链表，两个链表一一对应比较

相等一起放入链表c;
相比较，小的值放入链表c，并且小的值对应指针后移，链表c指针后移;

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    ListNode temp1=l1;
    ListNode temp2=l2;

    ListNode head=new ListNode(-1);
    ListNode temp3=head;

      if (l2 == null) 
        {
            return l1;
        }
        else if (l1 == null) 
        {
            return l2;
        }


    while(temp1!=null&&temp2!=null)
    {
        if (temp1.val==temp2.val)
        {
            temp3.next=temp1;
            temp1=temp1.next;
            
            temp3=temp3.next;
            temp3.next=temp2;

            temp2=temp2.next;
            temp3=temp3.next;

        }

        else if (temp1.val>temp2.val)
        {
            temp3.next=temp2;
            temp3=temp3.next;
            temp2=temp2.next;

        }

        else if (temp1.val<temp2.val)
        {
            temp3.next=temp1;
            temp3=temp3.next;
            temp1=temp1.next;
        }
    }

    return head.next;

    }
}
```

#快慢指针的应用



-------------------------------------------------------------------------

快慢指针的应用

## 链表中是否有环形链表

     [comment]: <思路>
定义两个指针，一个快指针(一次跳2个)，一个慢指针(一次跳1个)。


如果快指针先到达链表末端（下一个指向为空），则无链表环
如果快指针==慢指针，则还有链表环

     细节：如果是一个元素，直接返回
(循环)保证至少含有两个元素才可能存在链表环   

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        //定义快慢指针
    ListNode tempFast=head,tempSlow=head;
 

//如果没有元素和只有一个元素都是非环
  if(head==null)
  {
      return false;
  }
  else if(head.next==null)
  {
      return false;
  }

//必须保证快指针能跳两次（快能跳，慢就不用说了）
  while(tempFast!=null&&tempFast.next!=null)
  {

      tempSlow=tempSlow.next;
      tempFast=tempFast.next.next;
      if(tempSlow==tempFast)
      {
          return true;
      }
  }

  return false;

    }
}
```


-------------------------------------------------------------------------

## 给定一个头结点为 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。

     [comment]: <思路> 
   用快慢指针，快指针走两步，慢指针走一步
   当快指针走到结尾的时候，慢指针刚好走到中间。
   
     细节：遍历链表的判断条件为：fast!=null&&fast.next!=null


```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {

  ListNode fast=head,slow=head;

  //保证可以fast可以跳两步
while(fast!=null&&fast.next!=null)
{
     fast=fast.next.next;
     slow=slow.next;

}
return slow;

   
    }
}
```

-------------------------------------------------------------------------

#移除链表元素(删除多个重复的元素)
如 1 2 3 3 则删除 3 3

思路：
定义一个头结点，将原链表连接起来，这样可以保证，如果头结点是待删除的元素，仍然可以被删除

删除的思路：找待删除节点的上一个元素，让它指向待删除节点的下一个元素。

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {


        //创建一个新的节点
        ListNode newHead=new ListNode(-1);
        //指针
        ListNode temp=newHead;
        //连接头结点
        newHead.next=head;
        while(temp.next!=null)
        {
            if(temp.next.val==val)
            {
               
                temp.next=temp.next.next;
            
            }
            else{

                temp=temp.next;
            }
        }
        return newHead.next;
        
    }
}
```
