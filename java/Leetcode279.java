import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Leetcode279 {
    public static void main(String[] args) {
        int n = 2513;
        Solution1 s = new Solution1();
        System.out.println(s.numSquares(n));
    }
}

// 动态规划的方法
class Solution1 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; ++i) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; ++j) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}


// BFS的方法
class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        int step = 0;
        Vector<Integer> number = new Vector<>();
        for(int i = 1; i * i <= n; ++i){
            number.add(i * i);
        }
        while (!q.isEmpty()) {
            ++step;
            int size = q.size();
            for (int i = 0; i < size; ++i){
                int tmp = q.poll();
                for (int j = number.size() - 1; j >= 0; --j) {
                    int next = tmp - number.get(j);
                    if (next == 0)
                        return step;
                    else if (next > 0) {
                        q.offer(next);
                    }
                }
            }
        }
        return 0;
    }
}
