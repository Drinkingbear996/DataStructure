#用队列实现栈

```java
class MyStack {
    private Queue<Integer> a;//输入队列
    private Queue<Integer> b;//输出队列
    
    public MyStack() {
        
        //进队列
        a = new LinkedList<>();
        
        //出队列
        b = new LinkedList<>();
    }
    
    public void push(int x) {
        
        // offer()：往队列添加元素。如果队列已满直接返回false，队列未满则直接插入并返回
        
        a.offer(x);
        // 将b队列中元素全部转给a队列
        
        while(!b.isEmpty())
        {
        // poll()：取出并删除队头的元素，当队列为空,返回null；
            a.offer(b.poll());
        }
              
        // 交换a和b,使得a队列没有在push()的时候始终为空队列
        
        Queue temp = a;
        a = b;
        b = temp;
        
    }
    
    public int pop() {
        return b.poll();
    }
   
    public int top() {
        return b.peek();
    }
    
    public boolean empty() {
        return b.isEmpty();
    }
}
```