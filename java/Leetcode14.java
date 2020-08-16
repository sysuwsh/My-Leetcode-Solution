import java.util.Arrays;

public class Leetcode14 {
    public static void main(String[] args) {
        String[] strs = {"aba", "cba"};
        String prefix = new Solution14().longestCommonPrefix(strs);
        System.out.println(prefix);
    }
}

// 分治法解决
class Solution14{
    public String longestCommonPrefix(String[] strs){
        if(strs.length == 0)
            return "";
        else{
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, int start, int end){
        if(start == end) {
            return strs[start];
        }
        else{
            int mid = (end - start) / 2 + start;
            String leftStr = longestCommonPrefix(strs, start, mid);
            String rightStr = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(leftStr, rightStr);
        }
    }

    public String commonPrefix(String leftStr, String rightStr){
        int min_len = Math.min(leftStr.length(), rightStr.length());
        for(int i = 0; i < min_len; ++i){
            if(leftStr.charAt(i) != rightStr.charAt(i)) {
                return leftStr.substring(0, i);
            }
        }
        return leftStr.substring(0, min_len);
    }
}


// 将字符串数据排序后，比较第一个和最后一个即可
class Solution14_1{
    public String longestCommonPrefix(String[] strs){
        if(strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];
        Arrays.sort(strs);
        int  min_len = Math.min(strs[0].length(), strs[strs.length - 1].length());
        int index = 0;
        while(index < min_len && strs[0].charAt(index) == strs[strs.length - 1].charAt(index)){
            ++index;
        }
        return strs[0].substring(0, index);
    }
}

class Solution14_2{
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String prefix = strs[0];
        for(int i = 1; i < strs.length; ++i){
            prefix = longestCommonPrefix(prefix, strs[i]);
            if(prefix.length() == 0)
                break;
        }
        return prefix;
    }

    // 计算两个字符串的最长公共前缀
    public String longestCommonPrefix(String str1, String str2){
        int min_len = Math.min(str1.length(), str2.length());
        int index = 0;
        for(int i = 0; i < min_len; ++i){
            if(str1.charAt(i) == str2.charAt(i))
                ++index;
            else break;
        }
        return str1.substring(0, index);
    }
}
