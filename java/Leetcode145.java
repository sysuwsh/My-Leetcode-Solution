import java.util.*;

public class Leetcode145 {
}

// 迭代方式1，采用改造过后的先序遍历结果的逆序
class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                res.add(cur.val);
            }
            if (cur.left != null) {
                stack.add(cur.left);
            }
            if (cur.right != null) {
                stack.add(cur.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}

// 迭代方式2，严格按照后序遍历的顺序来
class Solution145_1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                if (cur.left != null)
                    cur = cur.left;
                else
                    cur = cur.right;
            }
            cur = stack.pop();
            res.add(cur.val);
            if (!stack.isEmpty() && stack.peek().left == cur)
                cur = stack.peek().right;
            else
                cur = null;
        }
        return res;
    }
}

// 递归的方式
class Solution145_2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if (root.left != null)
            postorder(root.left, res);
        if (root.right != null)
            postorder(root.right, res);
        res.add(root.val);
    }
}