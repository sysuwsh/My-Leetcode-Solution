import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Leetcode150 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(s.evalRPN(tokens));
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0)
            return 0;
        Set<String> operate = new HashSet<>();
        operate.add("+");
        operate.add("-");
        operate.add("*");
        operate.add("/");
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (operate.contains(token) && stack.size() > 1) {
                int first = stack.pop();
                int second = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(second + first);
                        break;
                    case "-":
                        stack.push(second - first);
                        break;
                    case "*":
                        stack.push(second * first);
                        break;
                    case "/":
                        stack.push(second / first);
                        break;
                }
            } else
                stack.push(Integer.parseInt(token));
        }
        return stack.peek();
    }
}
