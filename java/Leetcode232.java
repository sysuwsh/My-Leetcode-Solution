import java.util.Stack;

public class Leetcode232 {
    public static void main(String[] args) {

    }
}

class MyQueue {

    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;
    /** Initialize your data structure here. */
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackIn.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty())
                stackOut.add(stackIn.pop());
        }
        return stackOut.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty())
                stackOut.add(stackIn.pop());
        }
        return stackOut.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
