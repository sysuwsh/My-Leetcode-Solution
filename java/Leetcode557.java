import java.awt.*;

public class Leetcode557 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        String a = "Let's take LeetCode contest";
        System.out.println(s.reverseWords(a));
    }
}

class Solution1 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            res.append(new StringBuilder(word).reverse()).append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}


class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder(s);
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            while (j < s.length() && res.charAt(j) != ' ')
                ++j;
            reverse(res, i, j - 1);
            while (j < s.length() && res.charAt(j) == ' ')
                ++j;
            i = j;
        }
        return res.toString();
    }

    public void reverse(StringBuilder s, int start, int end) {
        while (start < end) {
            char tmp = s.charAt(start);
            s.setCharAt(start, s.charAt(end));
            s.setCharAt(end, tmp);
            ++start;
            --end;
        }
    }
}
