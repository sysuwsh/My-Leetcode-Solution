import java.util.ArrayList;
import java.util.List;

public class Leetcode155 {
    public static void main(String[] args) {

    }
}

class MinStack {

    private List<Integer> stack;
    private List<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new ArrayList<>();
        this.min = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
        if (min.isEmpty() || min.get(min.size() - 1) < x) {
            min.add(x);
        }
        else {
            min.add(min.get(min.size() - 1));
        }
    }

    public void pop() {
        stack.remove(stack.size() - 1);
        min.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min.get(this.min.size() - 1);
    }
}
