import java.util.LinkedList;
import java.util.Queue;

public class Leetcode225 {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.top();
        s.pop();

    }
}

class MyStack {

    private Queue<Integer> queueIn;
    private Queue<Integer> queueOut;
    /** Initialize your data structure here. */
    public MyStack() {
        queueIn = new LinkedList<>();
        queueOut = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queueIn.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queueIn.size();
        for (int i = 0; i < size - 1; ++i)
            queueOut.add(queueIn.poll());
        int res = queueIn.poll();
        Queue<Integer> tmp = queueIn;
        queueIn = queueOut;
        queueOut = tmp;
        return res;
    }

    /** Get the top element. */
    public int top() {
        int size = queueIn.size();
        for (int i = 0; i < size - 1; ++i)
            queueOut.add(queueIn.poll());
        int res = queueIn.peek();
        queueOut.add(queueIn.poll());
        Queue<Integer> tmp = queueIn;
        queueIn = queueOut;
        queueOut = tmp;
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queueIn.isEmpty() && queueOut.isEmpty();
    }
}