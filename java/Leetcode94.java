import java.util.*;

public class Leetcode94 {
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// 迭代的写法
class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}

// 递归的写法
class Solution94_1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> res = new ArrayList<>();
        recursion(root, res);
        return res;
    }

    public void recursion(TreeNode root, List<Integer> res) {
        if (root.left != null)
            recursion(root.left, res);
        res.add(root.val);
        if (root.right != null)
            recursion(root.right, res);
    }
}
