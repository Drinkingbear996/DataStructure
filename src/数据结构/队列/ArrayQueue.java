package 数据结构.队列;

import java.util.Scanner;

public class ArrayQueue {

    private int maxSize;    //表示数组的最大容量
    private int front;      //队列头
    private  int rear;      //队列尾
    private int  [] array;  //存放数据模拟队列

    public ArrayQueue(int arrMaxSize) {

    maxSize=arrMaxSize;
    array=new int[maxSize];
    front=-1; //指向队列头部，即队列头前一个位置
    rear=-1; //指向队列尾部，即最后一个数据
    }


    public boolean isFull()
    {

        return rear==maxSize-1;
    }

    public boolean isNull()
    {
        return front==rear;
    }



    public void addQueue(int n)
    {

        if (rear==maxSize-1)
        {
            System.out.println("队列满，不能加入数据");
            return;
        }
        else
        {
            rear++;
            array[rear]=n;
        }
    }

    public int getQueue()
    {
        if(isNull())
        {
            throw new RuntimeException("队列为空不能取出数据");
        }
        else
        {
             front++;
             return array[front];
        }
    }

    public void listQueue()
    {
        //遍历
        if(isNull())
        {
            System.out.println("队列没有数据");
        }

        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]=%d\n",i,array[i]);
        }
    }

    public int HeadQueue()
    {
        if(isNull())
        {
            throw new RuntimeException("队列为空，没有数据");
        }
        return  array[front+1];
    }

    public static void main(String[] args) {

        //测试
        ArrayQueue arrayQueue = new ArrayQueue(3);

        arrayQueue.addQueue(3);
        arrayQueue.addQueue(5);
        arrayQueue.addQueue(4);


        arrayQueue.listQueue();

        System.out.printf("队列头为%d",arrayQueue.HeadQueue());

    }
}
