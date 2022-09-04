package 数据结构.队列;

/**
 * 1. 初始head tail 都指向-1,除此之外，head和tail都指向头和尾
 * 2. 队空条件为head==-1&&tail==-1
 * 3. 队满条件为 (tail+1)%size==head
 * 4. 考虑删除/添加的特殊情况: 不为空的情况下，考虑删除（队列只剩下一个元素）/ 添加（队列为空）时head==tail这种情况,将他们都设为-1 / 0;
 */
public class leetcode_循环队列 {

}

class MyCircularQueue {

    int a[];
    int head;
    int tail;
    int len;

    public MyCircularQueue(int k) {
        a = new int[k];
        head = -1;
        tail = -1;
        len = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            head = 0;
            tail = 0;
            a[head] = value;
        } else {
            tail = (tail + 1) % len;
            a[tail] = value;
        }
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (tail == head) {
            tail = -1;
            head = -1;
        } else {
            head = (head + 1) % len;
        }
        return true;
    }

    public int Front() {

        return isEmpty() ? -1 : a[head];
    }

    public int Rear() {

        return isEmpty() ? -1 : a[tail];
    }

    public boolean isEmpty() {

        return head == -1 && tail == -1;
    }

    public boolean isFull() {

        return (tail + 1) % len == head;

    }
}

