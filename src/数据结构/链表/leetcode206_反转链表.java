package 数据结构.链表;

public class leetcode206_反转链表 {
}
/**
 * 定义3个节点
 *  1.cur =head 需要反转的节点
 *  2.pre =null 反转节点重定向位置
 *  3.temp =cur.next 保存反转节点的下一个节点(因为已经重定向)
 *
 *  5.循环：保证当前节点不为空，才能反转
 * */
class Solution {
    //1.双指针法
    public ListNode reverseList(ListNode head) {

        ListNode cur=head;
        ListNode pre=null;
        ListNode temp=null;
        while(cur!=null)
        {
            temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;

        }

        return pre;

    }

    //2.递归法
    public ListNode reverseList2(ListNode head) {
        // 和双指针法初始化是一样的逻辑
        // ListNode cur = head;
        // ListNode pre = NULL;
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode temp = null;
        temp = cur.next;// 先保存下一个节点
        cur.next = pre;// 反转
        // 可以和双指针法的代码进行对比，如下递归的写法，其实就是做了这两步
        // pre = cur;
        // cur = temp;
        return reverse(cur, temp);
    }
}