package 数据结构.链表.单链表;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=head;
        while(head.next!=null)
        {
            if(temp.val==temp.next.val)
            {
                temp=temp.next.next;
            }
            else
            {
                temp=temp.next;
            }

        }
        return head;
    }


    public void addByOrder(ListNode node)
    {
        //指针
        ListNode NodePoint=node;

        boolean flag=false; //添加这个编号 是否存在


        //我们要找到位于添加位置的前一个节点

        while(true)
        {
            if (NodePoint.next==null) //说明指针已经在链表的最后
            {
                break;
            }

            if (node.val<NodePoint.next.val) //位置找到 ，跳出，在指针后面插入。
            {
                //这个就是正常的顺序
                break;
            }
            else if (node.val==NodePoint.next.val)
            {

                flag=true; //编号已经存在
                break;
            }

            NodePoint=NodePoint.next; //后移，遍历链表
        }

        //不能添加，说明编号存在
        if (flag)
        {
            System.out.printf("编号%d已经存在,不能加入\n",node.val);

        }
        else
        {
            node.next=NodePoint.next; //指针的下一个
            NodePoint.next=node;
        }
    }

}

class test{
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(2);

        ListNode no= new Solution().deleteDuplicates(node1);

        while(no.next!=null)
        {
            System.out.println(no.val);

            no=no.next;
        }
    }
}
