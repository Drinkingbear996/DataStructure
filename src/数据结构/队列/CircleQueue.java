package 数据结构.队列;

//环形队列
/**
 * 特点:
 * 1. front指向队列的第一个元素 初始值为0
 * 2. rear指向队列最后一个元素的后一个位置 初始值为0
 * 3. 当队列满，条件是(rear+1)%maxsize==front
 * 4. 队列为空 rear==front
 * 5. 我们这样分析，队列中有效数据的个数(rear+maxsize-front)%maxsize //rear=1 front=0
 * */


public class CircleQueue {

    private int maxsize;    //表示数组的最大容量
    private int front;      //队列头 front指向队列的第一个元素 初始值为0
    private  int rear;      //队列尾 rear指向队列最后一个元素的后一个位置 初始值为0
    private int  [] array;  //存放数据模拟队列

    public CircleQueue(int Maxsize) {
        maxsize=Maxsize;
        array=new int[maxsize];
    }

    public boolean isFull()
    {
        return (rear+1)%maxsize==front;
    }

    public boolean isEmpty()
    {
        return rear==front;
    }

    public void addQueue(int n)
    {
        if(isFull())
        {
            System.out.println("队列满，不能加入数据");
            return;
        }

        array[rear]=n;
        rear=(rear+1)%maxsize; //rear后移  取模？

    }

    public int getQueue()
    {
        if(isEmpty())
        {
            //抛出异常
            throw new RuntimeException("队列空，不能取数据！");

        }
        else
        {
            int temp= array[front];
            front=(front+1)%maxsize;
            return temp;
        }
    }

    //求出当前队列的有效数据的个数
    public int size()
    {
       //rear=1
        //front=0
        //maxsize=3

        return (rear+maxsize-front)%maxsize; //不理解？
    }

    //遍历
    public void listQueue()
    {
        //遍历
        if(isEmpty())
        {
            System.out.println("队列没有数据");
            return;
        }

        //从front开始遍历，遍历多少个元素
        for (int i = front; i < front+size(); i++) {
            System.out.printf("array[%d]=%d\n",i%maxsize,array[ i% maxsize]); //取模？
        }
    }

    //返回头元素
    public int HeadQueue()
    {
        if(isEmpty())
        {
            throw new RuntimeException("队列为空，没有数据");
        }
        return  array[front];
    }


  public static void main(String[] args){

        //测试数组模拟环形队列
      //测试
      CircleQueue circleQueue = new CircleQueue(4); //容量4 但是数据只含有3个，还有一个作为空

      circleQueue.addQueue(3);
      circleQueue.addQueue(6);
      circleQueue.addQueue(9);
      circleQueue.addQueue(10);//加入也无效

      circleQueue.listQueue();

      System.out.printf("队列头为%d",circleQueue.HeadQueue());


    }
}
