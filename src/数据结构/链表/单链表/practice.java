package 数据结构.链表.单链表;

public class practice {
}

class Nodetest
{
    private  int value;
    private  Nodetest next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Nodetest getNext() {
        return next;
    }

    public void setNext(Nodetest next) {
        this.next = next;
    }

    public Nodetest(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Nodetest{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}

class TestSingleList
{


    private Nodetest head=new Nodetest(-1);




    public void add( Nodetest nodetest)
    {
        Nodetest temp=head;

        while(true)
        {

            if (temp.getNext()==null)
            {

                break;
            }


                temp=temp.getNext();


        }
        temp.setNext(nodetest);

    }

    public void list()
    {
        Nodetest temp=head;

        while(true)
        {


            if (temp.getNext()==null)
            {
                break;
            }
            else
            {
                System.out.println(this);

            }
            temp=temp.getNext();
        }
    }

    public static void main(String[] args) {




       Nodetest nodetest1=new Nodetest(1);
        Nodetest nodetest2=new Nodetest(2);
        Nodetest nodetest3=new Nodetest(3);

        TestSingleList testSingleList=new TestSingleList();
        testSingleList.add(nodetest1);
        testSingleList.add(nodetest2);
        testSingleList.add(nodetest3);

        testSingleList.list();


    }

}