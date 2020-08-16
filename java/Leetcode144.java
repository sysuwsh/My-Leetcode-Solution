import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode144 {
}

// 迭代的方式
class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null)
                stack.add(cur.right);
            if (cur.left != null)
                stack.add(cur.left);
        }
        return res;
    }
}

// 递归的方式
class Solution144_1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        res.add(root.val);
        if (root.left != null)
            preorder(root.left, res);
        if (root.right != null)
            preorder(root.right, res);
    }
}