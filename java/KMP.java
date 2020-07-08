public class KMP {
   public static void main(String[] args) {
       String p = "ABBABBAAA";
       String s = "ADHJKLSJFDKLAABBABBAAAJDKSJDIWMF";
       KmpAlgorithm res = new KmpAlgorithm();
       System.out.println(res.kmp(s, p));
   }
}

class KmpAlgorithm {
   public int kmp(String s, String p){
       int i = 0;
       int j = 0;
       int[] next = buildNext(p);
       while (j < p.length() && i < s.length()) {
           if (j < 0 || p.charAt(j) == s.charAt(i)) {
               ++i;
               ++j;
           }
           else {
               j = next[j];
           }
       }
       return i - p.length();
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
