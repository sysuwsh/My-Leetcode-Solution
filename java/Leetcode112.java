import java.util.*;

public class Leetcode112 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;}
}


class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (sum == root.val && root.left == null && root.right == null)
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

class Solution1 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        Stack<TreeNode> stackNode = new Stack<>();
        stackNode.add(root);
        Stack<Integer> stackPath = new Stack<>();
        stackPath.add(root.val);
        while (!stackNode.isEmpty() && !stackPath.isEmpty()) {
            TreeNode node = stackNode.pop();
            int path = stackPath.pop();
            if (path == sum && node.left == null && node.right == null)
                return true;
            if (node.left != null) {
                stackNode.add(node.left);
                stackPath.add(path + node.left.val);
            }
            if (node.right != null) {
                stackNode.add(node.right);
                stackPath.add(path + node.right.val);
            }
        }
        return false;
    }
}

class Solution2 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        Queue<TreeNode> queueNode = new LinkedList<>();
        queueNode.offer(root);
        Queue<Integer> queuePath = new LinkedList<>();
        queuePath.offer(root.val);
        while (!queueNode.isEmpty() && !queuePath.isEmpty()) {
            TreeNode node = queueNode.poll();
            int path = queuePath.poll();
            if (path == sum && node.left == null && node.right == null)
                return true;
            if (node.left != null) {
                queueNode.offer(node.left);
                queuePath.offer(path + node.left.val);
            }
            if (node.right != null) {
                queueNode.offer(node.right);
                queuePath.offer(path + node.right.val);
            }
        }
        return false;
    }
}