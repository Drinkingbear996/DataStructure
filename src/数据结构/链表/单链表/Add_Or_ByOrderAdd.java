package 数据结构.链表.单链表;

public class Add_Or_ByOrderAdd {
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

    }



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
            node.next=NodePoint.next; //指针的下一个
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



}
