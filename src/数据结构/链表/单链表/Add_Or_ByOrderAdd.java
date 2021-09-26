package 数据结构.链表.单链表;

import java.util.Stack;

public class Add_Or_ByOrderAdd {


}

//创建一个节点类
class Node
{
    //数据域
  String data;
  int id;

    //next域
     Node next;


    //创建对象的时赋值信息
    public Node(String data, int id) {
        this.data = data;
        this.id = id;
    }



    //重写toString方法
    @Override
    public String toString() {
        return  "[data="+data+"]";

    }



}


class SingleList1 {
    //创建头节点，数据为空
    private Node head = new Node(null,0);

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void add(Node node) {
        //创建一个指针指向头部
        Node NodePoint = head;

        while (true) {

            //如果指针的下一个节点为null，则跳出
            if (NodePoint.next == null)
            {
                break;
            }

            //不为null，则指向下一个节点
            else
            {
                NodePoint = NodePoint.next;
            }
        }

            //循环结束后，当前节点为最后一个节点
        NodePoint.next = node;
    }


        //第二种通过id编号来遍历

    public void addByOrder(Node node)
    {
        //指针
        Node NodePoint=head;

        boolean flag=false; //添加这个编号 是否存在


        //我们要找到位于添加位置的前一个节点

        while(true)
        {
            if (NodePoint.next==null) //说明指针已经在链表的最后
            {
                break;
            }

            if (node.id<NodePoint.next.id) //位置找到 ，跳出，在指针后面插入。
            {
                //这个就是正常的顺序
                break;
            }
            else if (node.id==NodePoint.next.id)
            {

                flag=true; //编号已经存在
                break;
            }

            NodePoint=NodePoint.next; //后移，遍历链表
        }

        //不能添加，说明编号存在
        if (flag)
        {
            System.out.printf("编号%d已经存在,不能加入\n",node.id);

        }
        else
        {
            node.next=NodePoint.next; //指针的下一个为空
            NodePoint.next=node;
        }
    }

        //修改id对应的内容，但不能修改id
    public void update(Node InputNode)
    {

        if (head.next==null)
        {
            System.out.println("链表为空");
        }

            Node NodePoint=head.next;

            boolean flag=false; //表示是否找到该节点

        //通过while遍历链表
            while (true) {

                if (NodePoint == null) {
                    break;
                    //已经遍历完了
                }

                //如果找到跳出
                else if (NodePoint.id == InputNode.id) {
                    flag = true;
                    break;
                }
                NodePoint = NodePoint.next;
            }
                 //找到
                 if (flag)
                 {
                     NodePoint.data=InputNode.data;
                 }
                 else
                 {
                     //没有找到
                     System.out.printf("没有找到编号%d",InputNode.id);
                 }



    }


    //根据排名将数据插入某一个



    //删除节点
    public void del(int id)
    {
        //创建一个指针，指向头部
        Node temp=head;

        boolean flag=false;//标志是否找到待删除的节点

     while (true)
     {
         if (temp.next==null)//已经到了链表的最后
         {  break;

         }
         if (temp.next.id==id) //找到待删除节点的前一个节点 即temp指向的节点
         {
             flag=true;
             break;
         }

         temp=temp.next; //遍历
     }
     if (flag) //找到删除 如1 2 3 指针目前在1，由1指向3，2没有指向,会被垃圾回收机制删除
     {
         temp.next=temp.next.next;
     }
    else {
         System.out.printf("节点%d不存在",id);
     }


    }

    //遍历链表
    public void list() {

        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        //证明是有数据的,指针指向head的下一个
        Node NodePoint = head.next;

        System.out.println("输出节点信息");

        //遍历输出节点
        while (true) {
            //判断指针指向的节点是否是最后一个
            if (NodePoint == null) {
                //如果为空跳出
                break;
            }

            System.out.println( NodePoint);

            NodePoint = NodePoint.next;

        }
    }
    //面试题：求单链表中有效节点的个数
    public static  int getLength(Node head)
    {
        if (head.next==null)
        {
            return 0;
        }
        int length=0;

        Node temp=head;

        while (temp!=null)
        {
            length++;
            temp=temp.next;
        }
        return  length;
    }


    //面试题，查找链表中倒数第k个节点
    public static Node FindLastIndexNOde(Node head,int index)
    {

        //定义指针，指向head
        Node temp=head;
    if (temp.next==null)
    {
        return null;
    }

    //获取链表的长度
    int size=getLength(head);

        //判断索引是否有效
    if (index<0||index>size)
    {
      return null;
    }
    //5个节点 索引2  5-2=3 ，在最后一次for的遍历中，temp=temp.next会指向第4个节点
        int length=size-index;

        for (int i = 0; i <length; i++) {
            temp=temp.next;
        }
        //返回指针对应的节点
        return temp;


    }

    /**
     * 反转单链表
     *
     * */
  public  static  void  reverseList(Node head)
  {
        //辅助指针，遍历原来的链表

      //保证至少有两个节点
      if (head.next==null||head.next.next==null)
      {
            return ; //终止
      }
        //指针
      Node temp=head.next;
      //存储当前节点的下一个节点
      Node nextForNow=null;

      //反转头

      //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
      Node reverseHead=new Node("",0);


      /**
       * 反转链表思路：
       1. 先将所断节点的下一个节点存储起来
       2. 所断节点指向为反转节点的指向
       3. 反转头指向所断节点
       4. 指针移动，移动到（所保存节点）
       5. 循环
       6. 原头指向=反转头的指向

       * */
        while(temp!=null)
        {

          nextForNow=temp.next; //保存当前节点的下一个节点，后面需要使用
          temp.next=reverseHead.next; //将temp的下一个节点指向链表最前端
            System.out.println(temp.next);
          reverseHead.next=temp;//将temp连接到新的链表                                     】
          temp=nextForNow;//让temp后移




        }

        head.next=reverseHead.next; //原头的指向等于反转头的指向


  }


    /** 逆序打印单链表

     */
    public static  void ReversePrintList(Node head)
{
    Node temp=head.next;
    if (temp==null)
    {
        return ;
    }

    Stack<Node> stack = new Stack<>();


    //将链表所有节点压入栈
    while (temp!=null)
    {
        stack.push(temp);
        temp=temp.next;
    }

    //利用栈中的节点进行打印，pop出栈
    while (stack.size()>0)
    {
        System.out.println(stack.pop());
    }
}
/**
 * 合并两个有序的链表
 *
 * */




    public static void main(String[] args) {

        Node node1=new Node("a",1);
        Node node2=new Node("b",2);
        Node node3=new Node("c",3);
        Node node4=new Node("d",4);
        Node node5=new Node("e",5);

        SingleList1 singleList1=new SingleList1();

//        singleList1.add(node1);
//        singleList1.add(node2);
//        singleList1.add(node3);
//        singleList1.add(node4);
//        singleList1.add(node5);

        singleList1.addByOrder(node1);
        singleList1.addByOrder(node5);
        singleList1.addByOrder(node4);
        singleList1.addByOrder(node2);
        singleList1.addByOrder(node3);

        singleList1.list();


        Node Newnode2=new Node("f",2);
        singleList1.update(Newnode2);

        System.out.println("修改后的链表情况");

        singleList1.list();

        System.out.println("删除后链表的情况");

        singleList1.del(2);
        singleList1.list();

        System.out.println("链表中节点的个数");
        System.out.println("链表中节点的个数"+getLength(singleList1.getHead()));


        System.out.println("测试一下");

        Node res=FindLastIndexNOde(singleList1.getHead(), 2);
        System.out.println("输出倒数节点"+res.id+"    "+res);


        System.out.println("反转单链表");

        reverseList(singleList1.getHead());

        singleList1.list();

        System.out.println("---------逆序打印单链表------------");

        ReversePrintList(singleList1.getHead());
    }


}
