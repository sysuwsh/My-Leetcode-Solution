import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode151 {
    public static void main(String[] args) {
        Solution151 s = new Solution151();
        String a = "  hello   world! ";
        String b = s.reverseWords(a);
        System.out.print(b);
    }
}

class Solution151{
    public String reverseWords(String s){
        s = s.trim();
        StringBuilder res = new StringBuilder();
        String[] a =  s.split("\\s+");
        for(int i = a.length - 1; i >= 0; --i){
            res.append(a[i]);
            if(i != 0){
                res.append(" ");
            }
        }
        return res.toString();
    }
}

// 双端队列解法
class Solution151_1{
    public String reverseWords(String s){
        s = s.trim();
        ArrayDeque<String> dq = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        int left = 0;
        while(left < s.length()){
            if(s.charAt(left) != ' '){
                word.append(s.charAt(left));
            }
            if(s.charAt(left) == ' ' && word.length() > 0){
                dq.addFirst(word.toString());
                word.delete(0, word.length());
            }
            ++left;
        }
        dq.addFirst(word.toString());
        word.delete(0, word.length());
        int dqLen = dq.size();
        for(int i = 0; i < dqLen; ++i){
             if(i != dqLen - 1){
                 word.append(dq.getFirst()).append(" ");
             }
             else{
                 word.append(dq.getFirst());
             }
            dq.pollFirst();
        }
        return word.toString();
    }
}

// 自己写函数法
class Solution151_2{
    public String reverseWords(String s){
        if(s.length() == 0){
            return "";
        }
        s = s.trim();
        s = reverse(s, 0, s.length() - 1);
        StringBuilder word = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int i = 0;
        while(i < s.length()){
            int start = i;
            while(i < s.length() && s.charAt(i) != ' '){
                word.append(s.charAt(i));
                ++i;
            }
            res.append(reverse(word.toString(), 0, word.toString().length() - 1)).append(" ");
            word.setLength(0);
            while(i < s.length() && s.charAt(i) == ' '){
                ++i;
            }
        }
        res.delete(res.length() - 1, res.length());
        return res.toString();
    }

    public String reverse(String s, int start, int end){
        StringBuilder res = new StringBuilder();
        for(int i = end; i >= start; --i){
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}