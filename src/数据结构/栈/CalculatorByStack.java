package 数据结构.栈;
import javax.swing.table.TableRowSorter;

class ArrayStack2
{
    private  int maxSize; //初始栈的长度
    private int [] stack; //栈
    private  int top=-1;  //栈顶初始化为-1

    //构造器
    public ArrayStack2(int maxSize)
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


    //判断是不是一个运算符
    public boolean isOper(char val)
    {
        if (val=='+' || val=='-'||val=='*'||val=='/')
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int priority(int oper)
    {
        //判断优先级
        if (oper=='*'||oper=='/')
        {
            return 1;
        }
        else if (oper=='+'|| oper=='-')
        {
            return 0;
        }
        else
        {
            return -1;
        }

    }
    //一个方法，放回当前栈顶的值，但是不是真正的出栈


    //返回当前栈顶的值
    public int peek()
    {
        return stack[top];
    }



    //通过符号来判断
    public int cal(int num1,int num2,int oper)
    {
        int res=0;

        switch (oper)
        {
            case '+':
                res=num1+num2;
                break;

            case '-':
                res=num2-num1;

            case '*':
                res=num1*num2;

            case '/':
                res=num2/num1;

            default:
                break;
        }
        return res;
    }



}


public class CalculatorByStack {

    public static void main(String[] args) {

        String expression="3+2*6-2";

        //定义两个栈 一个数字栈，一个符号栈
        ArrayStack2 numStack=new ArrayStack2(10);
        ArrayStack2 OperStack=new ArrayStack2(10);


        //定义需要的相关变量
        int index=0;
        int num1=0;
        int num2=0;
        int oper=0;
        int res=0;
        char ch=' '; //将每次扫描得到的char保存到ch

        //用while扫描每一个字符

        while(true)
        {
            ch=expression.substring(index,index+1).charAt(0);
            //判断ch是什么，然后做相应的处理

            if (OperStack.isOper(ch))
            {
                //如果是运算符

                //判断当前的符号栈是否为空
                if (!OperStack.isEmpty())
                {
                    //如果符号栈中有操作符，比较，若小于等于栈中的操作符，则pop两个数
                    //再从符号栈中pop一个符号，进行运算，得到结果，入栈，然后当前的操作符入符号栈。

                    if (OperStack.priority(ch)<= OperStack.priority(OperStack.peek()))
                    {
                        num1=numStack.pop();
                        num2=numStack.pop();
                        oper=OperStack.pop();
                        res=numStack.cal(num1,num2,oper);

                        //把运算的结果入数栈
                        numStack.push(res);

                        //然后将dan
                        OperStack.push(ch);


                    }
                    else
                    {
                        //如果当前操作符的优先级大于栈中的操作符，就直接入符号栈
                        OperStack.push(ch);

                    }
             }
                else
                {
                    //为空就直接入符号栈
                    OperStack.push(ch); //1+3
                }
            }
            else
            {
                //如果是数，则直接入数栈

                numStack.push(ch - 48);
            }
            //让index+1,判断是否扫描到expression的最后

            index++;
            if (index>=expression.length())
            {
                break;
            }
        }

        //当表达式扫描完毕，就按顺序的从数栈和符号栈中pop相应的数和符号，并运行
        while (true)
        {
            //如果符号栈为空，则计算到最后的结果，数栈中只有一个数字

            if (OperStack.isEmpty())
            {
                break;
            }
            num1=numStack.pop();
            num2=numStack.pop();
            oper=OperStack.pop();
            res=numStack.cal(num1,num2,oper);

            //把运算的结果入数栈
            numStack.push(res);

            //将数栈中最后的数pop出来，就是结果
            System.out.printf("表达式%s = %d",expression,numStack.pop());

        }

    }
}
