import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode102 {

}

class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        res.add(rootList);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                    tmp.add(cur.left.val);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    tmp.add(cur.right.val);
                }
            }
            res.add(tmp);
        }
        return res.subList(0, res.size() - 1);
    }
}

class Solution102_1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        recursion(root, 0, ans);
        return ans;
    }

    public void recursion(TreeNode root, int depth, List<List<Integer>> ans) {
        if (root == null)
            return;
        if (depth >= ans.size())
            ans.add(new ArrayList<>());
        ans.get(depth).add(root.val);
        recursion(root.left, depth + 1, ans);
        recursion(root.right, depth + 1, ans);
    }
}