import java.util.LinkedList;
import java.util.Queue;

public class Leetcode101 {
}

// 递归的方式
class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return recursion(root.left, root.right);
    }

    public boolean recursion(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null)
            return true;
        if (leftNode == null || rightNode == null)
            return false;
        if (leftNode.val != rightNode.val)
            return false;
        return recursion(leftNode.left, rightNode.right) && recursion(leftNode.right, rightNode.left);
    }
}

// 迭代的方式
class Solution101_1 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (leftNode == null && rightNode == null)
                continue;
            if (leftNode == null || rightNode == null)
                return false;
            if (leftNode.val != rightNode.val)
                return false;
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }
}
