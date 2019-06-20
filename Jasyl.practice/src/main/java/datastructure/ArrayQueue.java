package datastructure;

/**
 * Description:
 * Author: lingyou
 * date: 2019-06-18 23:33
 */
public class ArrayQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;


    public ArrayQueue(int capacity) {
        this.items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        //表示队列已满
        if (tail == n) {
            return false;
        }
        items[tail] = item;
        ++tail;
        return true;
    }


    public boolean enqueue2(String item) {
        //表示队列末尾已满
        if (tail == n) {
            //表示整个队列都满了
            if (head == 0) {
                return false;
            }

            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
            
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        ++head;
        return ret;
        
    }
}
