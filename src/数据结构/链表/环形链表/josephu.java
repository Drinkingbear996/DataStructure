package 数据结构.链表.环形链表;

public class josephu {

    /**
     * 环形链表思路：我们要用到两个指针，一个指针用户遍历链表，一个指针将最后一个节点指向头结点
     * <p>
     * 创建first节点 ,创建一个节点，就把first指向该节点，形成环形
     * 后面我们每创建一个新的节点，就把该节点加入链表中
     * <p>
     * <p>
     * //遍历环形链表，通过while循环，当最后一个节点指向first就结束
     */


    public static void main(String[] args) {

        //测试 构建和遍历环形链表

        CircleList circleList = new CircleList();


        circleList.addBoy(5);

        circleList.ShowBoy();

        //测试小孩出圈
        circleList.countBoy(1, 2, 5);

    }
}


class Boy {
    private int id;
    private Boy next; //指向下一个节点

    public Boy(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                '}';
    }
}

class CircleList {

    private Boy head = new Boy(-1);

    public void addBoy(int nums)//nums为节点的总数
    {

        if (nums < 2) {
            System.out.println("nums值不正确"); //至少两个节点
            return;
        }
        //创建环形链表

        Boy temp = null; //指针，用于遍历链表,挨个指向
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);

            //如果是第一个小孩
            if (i == 1) {
                head = boy;
                head.setNext(head);

                temp = head;
            } else {/**

             连接新的节点boy
             （原本的最后一个节点指向head，现在指向新的节点，
             新的节点指向head，然后指针移动到最后一个节点）

             */


                temp.setNext(boy); //当前指针指向的这个节点(head/boy)指向新的boy

                //疑问？ 为什么不用head.setNext，如果用head的话，那下一次增添要用boy1...boy2...boyn,y
                //每一增添个变量都要写一遍吗？ 我们可以用temp指针来指代当前变量
                boy.setNext(head); //新的boy首尾连接，连上head
                temp = boy;          //temp移动，指向新的boy

            }

        }

    }

    public void ShowBoy() {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        //因为head不能动

        Boy temp = head;

        while (true) {
            System.out.printf("小孩的编号%d\n", temp.getId());
            if (temp.getNext() == head) {
                break;
            }

            temp = temp.getNext(); //后移

        }

    }

    /**
     * josephu 实现思路：
     * 用户输入，实现小孩出圈的顺序 m：报5出去 sums总人数 起始点:1
     * 1.创建一个指针helper ，指针指向环形链表的最后一个节点，head是头节点
     * <p>
     * 小孩报数前，先让head和helper移动
     * 2.当小孩报数时，让head和helper同时移动 移动m-1次
     * 这时head指向（假定为a出圈) a
     * head=head.next  指向a的下一个
     * helper=head helper指向 a的下一个 也就是当前的head节点
     */

    //数几下：countnum 总人数:countnum 起始点:startno
    public void countBoy(int startno, int countnum, int sums) {

        //1.
        //对数据进行校验
        if (head == null || startno < 1 || startno > sums) {
            System.out.println("参数输入有误!");
        }
        //创建辅助指针
        Boy helper = head;
        while (true) {
            if (helper.getNext() == head) {
                break;   //说明这是最后一个节点
            }

            helper = helper.getNext();
        }

        //从n节点开始就移动多少n-1次
        for (int i = 0; i < startno - 1; i++) {
            head = head.getNext();
            helper = helper.getNext();
        }

        //当小孩报数时，让head和helper同时移动 m-1次

        while (true) {
            if (helper == head) //说明圈中只有一个节点
            {
                break;
            }

            //让head和helper同时移动CountNum-1次

            for (int i = 0; i < countnum - 1; i++) {
                head = head.getNext();
                helper = helper.getNext();

            }
            //
            System.out.printf("小孩%d出圈\n", head.getId());
            head = head.getNext();
            helper.setNext(head);
        }
        //循环结束后，留下最后的人
        System.out.printf("最后留在圈中的小孩编号%d\n", head.getId());

    }


}