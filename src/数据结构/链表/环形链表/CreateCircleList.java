package 数据结构.链表.环形链表;

public class CreateCircleList {

}


class node
{
    node next;
    int id;

    public node(int id) {
        this.id = id;
    }

    public node getNext() {
        return next;
    }

    public void setNext(node next) {
        this.next = next;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}

class circle
{
   private node n=new node(-1);

   public void add(node node)
   {

   }
}