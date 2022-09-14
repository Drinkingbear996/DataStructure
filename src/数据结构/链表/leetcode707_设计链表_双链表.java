package 数据结构.链表;

import java.util.List;

public class leetcode707_设计链表_双链表 {

    //1.单链表和双链表在插入节点时用逆时针法 右上 左上 左下 右下
    //2.双链表中间插入、删除跟单链表一样查找目标节点的上一个节点
}



class node
{
    int val;
    node next,prev;

    node(int x)
    {
        val=x;
    }

}
class myLinkedList
{
//设定头结点和尾节点
    node head,tail;
    int size;

    public myLinkedList()
    {
        size=0;
        head=new node(0);
        tail=new node(0);

        head.next=tail;
        tail.prev=head;
    }

    public int get(int index)
    {
        if(index<0||index>=size)
        {
            return -1;
        }
        node cur=head;

        // (偶数-1)/2 从头开始遍历快,(奇数-1)/2 从后面开始遍历快

         if (index<(size -1 )/2)
        {
              for(int i=0;i<=index;i++)
              {
                  cur=cur.next;
              }
        }else
         {
             cur=tail;
             for(int i=0;i<size-1-index;i++)
             {
                 cur=cur.prev;
             }
         }
         return  cur.val;
    }
    public  void  addAtHead(int val)
    {
        node cur=head;

        node newnode=new node(val);

        newnode.next=cur.next;
        cur.next=newnode;
        cur.next.prev=newnode;
        newnode.prev=cur;
        size++;
    }

    public void addTail(int val)
    {
        node cur=tail;

        node newnode=new node(val);
        newnode.next=tail;
        cur.prev.next=newnode;
        newnode.prev=cur.prev;
        cur.prev=newnode;
        size++;

    }

    public void addAtIndex(int index,int val)
    {
        if(index>size)
        {
            return;
        }
        if(index<0)
        {
            index=0;
        }
        node cur=head;

        for(int i=0;i<index;i++)
        {
            cur=cur.next;
        }

        node newnode=new node(val);

        newnode.next=cur.next;
        cur.next=newnode;
        newnode.prev=cur;
        cur.next.prev=newnode;
        size++;

    }

    public void deleteAt(int index){
        if(index>=size||index<0){
            return;
        }
        node cur=head;

        for(int i=0;i<index;i++)
        {
            cur=cur.next;
        }

        cur.next.next.prev=cur;
        cur.next=cur.next.next;
        size--;
    }
}