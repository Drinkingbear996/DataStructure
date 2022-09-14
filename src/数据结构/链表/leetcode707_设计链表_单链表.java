package 数据结构.链表;

public class leetcode707_设计链表_单链表 {

    /**无论
     * 1.查找,删除,增加 都找目标节点的前一个节点
     * 2.删除要额外判断头节点的情况
     * */
}

//单链表
class MyLinkedList
{
 int size;

 Node head;

 //单链表--初始化节点数和头结点
 public MyLinkedList()
 {
     size=0;
     head=new Node(0);
 }

 //获取第index个索引的值
 public int get(int index)
 {
     if(index<0||index>=size)
     {
         return -1;
     }
     //虚拟头结点的值

     Node cur=head;
     //包含一个虚拟头节点，所以查找第 index+1 个节点
     for (int i = 0; i <= index; i++) {
        cur=cur.next;
     }
     return cur.val;
 }
    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空

    public void addAtIndex(int index,int val)
    {
        if(index>size)
        {
            return;
        }

        if (index<0)
        {
            index=0;
        }

        size++;

        //找到插入节点的前驱
        Node pre=head;
        for (int i = 0; i < index; i++) {
            pre=pre.next;
        }

        //创建要添加的节点
    Node toAdd=new Node(val);
    toAdd.next=pre.next;
    pre.next=toAdd;
 }

 public void deleteAtIndex(int index)
 {
     if(index<0||index >=size)
     {
         return;
     }

     size--;
     //如果删除的是头结点
     if (index==0)
     {
         head=head.next;
         return;
     }

     //如果删除的是中间节点则要找他的前驱

     //设置虚拟节点
     Node pre=head;
     for (int i = 0; i < index; i++) {
         pre=pre.next;
     }
     pre.next=pre.next.next;
 }

}

class Node
{
    Node next;
    int val;

    public Node(int val)
    {
        this.val=val;
    }

    public Node()
    {

    }
}