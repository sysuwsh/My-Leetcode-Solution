import java.util.Stack;

public class Leetcode20 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String a = "[]{]]]]]";
        System.out.println(s.isValid(a));
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else if (!stack.isEmpty() && s.charAt(i) == ')' && stack.peek() == '(')
                stack.pop();
            else if (!stack.isEmpty() && s.charAt(i) == ']' && stack.peek() == '[')
                stack.pop();
            else if (!stack.isEmpty() && s.charAt(i) == '}' && stack.peek() == '{')
                stack.pop();
            else
                return false;
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}
