import java.util.Arrays;
import java.util.Stack;

public class Leetcode739 {
    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        Solution739 s = new Solution739();
        System.out.println(Arrays.toString(s.dailyTemperatures(T)));
    }
}

class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; ++i) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
