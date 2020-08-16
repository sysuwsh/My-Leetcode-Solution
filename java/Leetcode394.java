import java.util.Stack;

public class Leetcode394 {
    public static void main(String[] args) {
    }
}

// 使用stack的解法
class Solution394 {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int num = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                numStack.add(num);
                strStack.add(res.toString());
                num = 0;
                res = new StringBuilder();
            } else if (s.charAt(i) == ']') {
                String preStr = strStack.pop();
                int curNum = numStack.pop();
                String tmp = res.toString();
                for (int j = 0; j < curNum -1 ; j++) {
                    res.append(tmp);
                }
                res = new StringBuilder(preStr + res);
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + Integer.parseInt(s.charAt(i) + "");
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}

class Solution394_1 {
    public String decodeString (String s) {
        return dfs(0, s)[0];
    }

    public String[] dfs(int i, String s) {
        int num = 0;
        StringBuilder res = new StringBuilder();
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + Integer.parseInt(s.charAt(i) + "");
            } else if (s.charAt(i) == '[') {
                String[] tmp = dfs(i + 1, s);
                i = Integer.parseInt(tmp[0]);  // 这里要更新i是因为在递归的部分，已经遍历了一段了，因此要从递归结束的地方继续向下走
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < num; j++) {
                    str.append(tmp[1]);
                }
                res.append(str);
                num = 0;
            } else if (s.charAt(i) == ']') {
                return new String[]{ String.valueOf(i), res.toString() };
            } else {
                res.append(s.charAt(i));
            }
            ++i;
        }
        return new String[]{ res.toString() };
    }
}