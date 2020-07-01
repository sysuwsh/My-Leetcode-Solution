public class Leetcode5 {
    public static void main(String[] args) {
        String a = "abcdefg";
        System.out.println(new Solution1().longestPalindrome(a));
    }
}

// 中心扩散法
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        int[] tmp = new int[]{0, 0};  // tmp[0]表示起始位置 tmp[1]表示字符串最大长度
        for(int i = 0; i < s.length() - 1; ++i){
            findPalindrome(s, i, i, tmp);
            findPalindrome(s, i, i + 1, tmp);
        }
        return s.substring(tmp[0], tmp[0] + tmp[1]);
    }

    public void findPalindrome(String s, int left, int right, int[] tmp) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            --left;
            ++right;
        }
        if(right - left - 1 > tmp[1]){
            tmp[1] = right - left - 1;
            tmp[0] = left + 1;
        }
    }
}

// 动态规划
class Solution1{
    public String longestPalindrome(String s){
        int  sLen = s.length();
        if(sLen < 2){
            return s;
        }
        int[][] dp = new int[sLen][sLen];
        for(int i = 0; i < sLen; ++i){
            dp[i][i] = 1;
        }
        int maxLen = 0;
        int x = 0;
        int y = 0;
        for(int j = 1; j < sLen; ++j){
            for(int i = 0; i < j; ++i){
                if(i + 1 == j && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2;
                    if(dp[i][j] > maxLen){
                        maxLen = dp[i][j];
                        x = i;
                        y = j;
                    }
                }
                else if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] > 0){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    if(dp[i][j] > maxLen){
                        maxLen = dp[i][j];
                        x = i;
                        y = j;
                    }
                }
            }
        }
        return s.substring(x, y + 1);
    }
}
