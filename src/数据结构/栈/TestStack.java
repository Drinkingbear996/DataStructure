package 数据结构.栈;

import java.util.Scanner;

class ArrayStack
{
    private  int maxSize; //初始栈的长度
    private int [] stack; //栈
    private  int top=-1;  //栈顶初始化为-1

    //构造器
    public ArrayStack(int maxSize)
    {
        this.maxSize=maxSize;
        stack=new int[maxSize];
    }

    //判断栈是否满

    public boolean isFull()
    {
        return  top==maxSize-1;
    }

    //判断栈是否是空

    public boolean isEmpty()
    {
        return  top==-1;
    }

    //入栈
    public  void push(int value)
    {
        if (isFull())
        {
            System.out.println("栈满");
            return;

        }
        top++;
        stack[top]=value;
    }

    //出栈
    public int pop()
    {
        if (isEmpty())
        {
            //抛出异常
            throw  new RuntimeException("栈空");
        }

        int value=stack[top];
        top--;

        return value;
    }

    //遍历栈
    public void list()
    {
        if (isEmpty())
        {
            System.out.println("栈空");
            return;
        }

        for (int i=top; i>=0; i--)
        {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }

    }



}

public class TestStack {
    public static void main(String[] args) {

        ArrayStack as=new ArrayStack(10);

        boolean loop=true;
        String key="";  //控制菜单

        Scanner in=new Scanner(System.in);



        while (loop)
        {

            System.out.println(" show 显示栈");
            System.out.println(" exit 退出");
            System.out.println(" push 入栈");
            System.out.println(" pop  出栈");
            System.out.println("list  遍历");
            System.out.println("请选择");

            key=in.next();
            switch (key)
            {
                case  "show":
                    as.list();
                    break;

                case  "exit":
                    return;

                case  "push":
                    System.out.print("请输入要添加的元素:");
                    int value=in.nextInt();
                    as.push(value);
                    break;
                case "pop":
                    as.pop();
                    break;



            }
        }

    }
}
