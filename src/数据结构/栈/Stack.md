#最小栈

设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top()—— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。

#
用到的方法(Stack)
peek() 返回栈顶的元素但不移除它
Math.min(x,y) 比较x,y。返回较小的那个
Stack.pop();
Stack.push();
Stack.top();

[comment]: <> (思路)
1. 建立两个栈，一个放入元素，另一个放元素栈当前的最小元素
2. 放入一个元素，就返回当前栈的最小值，放入最小栈中

```java
class MinStack {
    Deque<Integer> xStack;

    //辅助栈
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        //放入Integer的最大值作为最小栈的栈底
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        //放入一个元素
        xStack.push(x);
        //比较出最小的元素
        minStack.push(Math.min(minStack.peek(), x));
    }
    
    public void pop() {
        //同时弹出栈和最小栈顶部的值
        xStack.pop();
        minStack.pop();
    }
    
    public int top() {
         //返回栈顶部的值，不弹出
        return xStack.peek();
    }
    
    public int getMin() {
        //返回最小栈的顶部的值，不弹出
        return minStack.peek();
    }
}
```
------------------------------------------------------------------------------------