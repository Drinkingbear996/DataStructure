package 数据结构.链表;

public class leetcode24_两两交换链表中的节点 {

    /**
     * 1、创建虚拟头节点，只做节点之间的交换，dummyNode.next=head;
     * 2、创建虚拟指针 prev，用于迭代链表
     *
     * */




// 虚拟头结点（0）- 1 - 2 - 3 - 4
    // 连接顺序 0 -> 2 -> 1 -> 3
        //虚拟指针，头结点递增
    public ListNode swapPairs(ListNode head) {

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;

        while(prev.next!=null && prev.next.next!=null)
        {
            ListNode temp = head.next.next; // 缓存 next
            prev.next = head.next;          // 将 prev 的 next 改为 head 的 next
            head.next.next = head;          // 将 head.next(prev.next) 的next，指向 head
            head.next = temp;               // 将head 的 next 接上缓存的temp
            prev = head;                    // 步进1位
            head = head.next;               // 步进1位

        }

        return dummyNode.next;
    }

}
