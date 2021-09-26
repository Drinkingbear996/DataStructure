package 数据结构.链表.双链表;



//创建一个节点类
class Node
{
    //数据域
    public   String data;
    public  int id;

    //next域
    public   Node next;
    public  Node pre; //指向前一个节点


    //创建对象的时赋值信息
    public Node(String data, int id) {
        this.data = data;
        this.id = id;
    }



    //重写toString方法
    @Override
    public String toString() {
        return  "[data="+data+ ",id="+id +"]";

    }

}
public class DoubleList {

    private Node head = new Node(null,0);

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
        //最后一个节点指向指针所对应的节点
        node.pre=NodePoint;
    }


    public void update(Node InputNode)
    {

        if (head.next==null)
        {
            System.out.println("链表为空");
        }

        Node temp=head.next;

        boolean flag=false; //表示是否找到该节点

        //通过while遍历链表
        while (true) {

            if (temp == null) {
                break;
                //已经遍历完了
            }

            //如果找到跳出
            else if (temp.id == InputNode.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //找到
        if (flag)
        {
            temp.data=InputNode.data;
        }
        else
        {
            //没有找到
            System.out.printf("没有找到编号%d",InputNode.id);
        }



    }
    /**
     * 双向链表的删除，不需要找到删除节点的前一个节点，找到后自我删除。
     * */
    public void del(int id)
    {
        //定义指针
        Node temp=head.next;

        if (head.next==null)
        {
            System.out.println("链表为空，不能删除");
            return;
        }

        while (temp!=null)
        {
            if (temp==null)
            {
                return;
            }

            if (temp.id==id)
            {
                //这个相当于是单向链表的删除
            temp.pre.next=temp.next;

        /**这里的代码有问题？如果是删除的是最后一个节点，就会出现空指针异常
            //如果是最后一节点就不执行下面这句话
           */
                if (temp.next!=null)
                 {
                    temp.next.pre=temp.pre;
                 }

            }


            temp=temp.next;
        }

    }

    public static void main(String[] args) {

        System.out.println("双向链表的测试");

        Node n1=new Node("小a",1);
        Node n2=new Node("小b",2);
        Node n3=new Node("小c",3);
        Node n4=new Node("小d",4);

        DoubleList doubleList=new DoubleList();

        doubleList.add(n1);
        doubleList.add(n2);
        doubleList.add(n3);
        doubleList.add(n4);
//
//        doubleList.list();
//
//        System.out.println("修改测试");
//
//        Node newn2=new Node("小x",3);
//
//        doubleList.update(newn2);
//
//        doubleList.list();

        System.out.println("删除测试");

        doubleList.del(3);

        doubleList.list();
    }
}
