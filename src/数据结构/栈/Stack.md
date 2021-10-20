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
#删除字符串中的所有相邻重复项

给出由小写字母组成的字符串，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

在 S 上反复执行重复项删除操作，直到无法继续删除。

在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

#
用到的方法

[comment]: <> (StringBuffer类) 
StringBuffer s

S.append(); 拼接字符串
S.deleteCharAt(); 删除对应符号的字符

[comment]: <> (String类) 
String S

S.charAt()  拿出相应序号的字符


#思路:
 1. 将字符串逐个放入StringBuffer中。
 2. top表示StringBuffer中最末端的字符

```java
class Solution {
    public String removeDuplicates(String s) {
        
        StringBuffer stack = new StringBuffer();
        //top表示StringBuffer的索引
        int top = -1;
        
        for (int i = 0; i < s.length(); ++i) {
            //获取字符
            char ch = s.charAt(i);
            
            //如果
            // StringBuffer中没有字符，top=-1，则放入当前字符进去
            // StringBuffer中最末端的字符与当前字符比较相同，则删除StringBuffer中的字符串
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                //索引--
                --top;
            } else {
                //放入字符
                stack.append(ch);
                //StringBuffer索引++
                ++top;
            }
        }
        return stack.toString();
    }
}


```

------------------------------------------------------------------------------------

#有效的括号

#
用到的方法：
 Stack

[comment]: <> (思路:)
用栈

```java
class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for (char ch : charArray) {
            //如果是左括号则直接入栈
            if (ch == '(' || ch == '{' || ch == '[') 
            {
                stack.push(ch);
            } 
            else 
            {
                //如果是右括号，并且此时栈不为空
                if (!stack.isEmpty()) {
                    if (ch == ')') 
                    {
                        if (stack.pop() != '(')
                            return false;
                    } 
                    else if (ch == '}') 
                    {
                        if (stack.pop() != '{')
                            return false;
                    } 
                    else if(ch == ']')
                    {
                        if (stack.pop() != '[')
                            return false;
                    }
                }
                else
                { //此时栈为空，但却来了个右括号，也直接返回false
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
```


------------------------------------------------------------------------------------

#栈模拟队列

定义一个输入栈和输出栈

思路：请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 
每pop和peek时
  若输出栈有值，则弹出，
  若输出栈为空，则将输入栈的值全部放入输出栈。

```java
import java.util.Stack;

class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

 public MyQueue() {
  inStack = new Stack<>();
  outStack = new Stack<>();
 }

 public void push(int x) {
  inStack.push(x);
 }

 public int pop() {
  if (outStack.isEmpty()) {
   in2out();
  }
  return outStack.pop();
 }

 public int peek() {
  if (outStack.isEmpty()) {
   in2out();
  }
  return outStack.peek();
 }

 public boolean empty() {
  return inStack.isEmpty() && outStack.isEmpty();
 }

 private void in2out() {
  while (!inStack.isEmpty()) {
   outStack.push(inStack.pop());
  }
 }
}

```