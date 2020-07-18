import java.util.ArrayList;
import java.util.List;

public class Leetcode118 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int a = 0;
        List<List<Integer>> res = s.generate(a);
        for (List<Integer> x : res) {
            for (Integer y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}

// 动态规划方法
class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        res.add(new ArrayList<>(tmp));
        for (int i = 1; i < numRows; ++i) {
            tmp.add(1);
            for (int j = i - 1; j > 0; --j) {
                tmp.set(j, tmp.get(j) + tmp.get(j - 1));
            }
            res.add(new ArrayList<>(tmp));
        }
        return res;
    }
}

// 普通方法
class Solution1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1)
            return res;
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        res.add(tmp);
        if (numRows == 1)
            return res;
        for (int i = 1; i < numRows; ++i){
            tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 1; j < i; ++j) {
                tmp.add(res.get(i - 1).get(j- 1) + res.get(i - 1).get(j));
            }
            tmp.add(1);
            res.add(tmp);
        }
        return res;
    }
}
