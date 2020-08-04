import java.util.PrimitiveIterator;

public class Leetcode104 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


// 采用自顶向下，dfs的方式来解决
class Solution {
    private int ans = 0;

    public int maxDepth(TreeNode root) {
        recursion(root, 1);
        return ans;
    }

    public void recursion(TreeNode root, int depth) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            ans = Math.max(ans, depth);
        recursion(root.left, depth + 1);
        recursion(root.right, depth + 1);
    }
}

// 采用自低向上的方式，可以理解为根节点的最大高度为max(左子树高度, 右子树高度) + 1
// 因此对于每一个节点都可以这样递归，而遇到叶子节点就回溯高度
class Solution1 {
    public int maxDepth(TreeNode root) {
        return recursion(root);
    }

    public int recursion(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = recursion(root.left);
        int rightDepth = recursion(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}