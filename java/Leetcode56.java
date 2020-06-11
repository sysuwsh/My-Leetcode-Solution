import java.util.Arrays;
import java.util.Comparator;

public class Leetcode56 {
    public static void main(String[] args) {
        int[][] a = {{1, 3}, {0, 0}, {0, 4}, {2, 8}, {9, 10}};
        Solution s = new Solution();
        a = s.merge(a);
        for(int i = 0; i < a.length; ++i) {
            for (int j = 0; j < a[0].length; ++j) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        // 先排序
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        // 采用lambda函数的表示法
        // Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        if (intervals.length <= 1)
            return intervals;
        int[][] result = new int[intervals.length][2];
        result[0] = intervals[0];
        int tail = 0;
        for (int i = 1; i < intervals.length; ++i) {
            if (result[tail][1] >= intervals[i][0]) {
                result[tail][1] = Math.max(result[tail][1], intervals[i][1]);
            }
            else {
                result[++tail] = intervals[i];
            }
        }
        return Arrays.copyOf(result, tail + 1);
    }
}