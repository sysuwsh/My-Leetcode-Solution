import java.util.ArrayList;
import java.util.List;

public class Leetcode119 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 5;
        System.out.println(s.getRow(n).toString());
    }
}

class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            res.add(1);
            for (int j = i - 1; j > 0; --j) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }
}