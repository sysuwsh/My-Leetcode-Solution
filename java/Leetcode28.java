public class Leetcode28 {
   public static void main(String[] args) {

   }
}

class Solution28 {
   public int strStr(String haystack, String needle) {
       if (needle.length() == 0)
           return 0;
       int i = 0;
       int j = 0;
       int[] next = buildNext(needle);
       while (i < haystack.length() && j < needle.length()) {
           if (j < 0 || needle.charAt(j) == haystack.charAt(i)) {
               ++i;
               ++j;
           }
           else {
               j = next[j];
           }
       }
       if (j == needle.length())
           return i - j;
       else
           return -1;
   }

   public int[] buildNext(String p){
       int[] res = new int[p.length()];
       res[0] = -1;
       int t = res[0];
       int j = 0;
       while (j < p.length() - 1) {
           if (t < 0 || p.charAt(t) == p.charAt(j)) {
               ++t;
               ++j;
               res[j] = t;
           }
           else {
               t = res[t];
           }
       }
       return res;
   }
}
