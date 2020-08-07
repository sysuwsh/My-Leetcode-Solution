import java.util.Arrays;

public class Leetcode105 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;}
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        return recursion(preorder, inorder);
    }

    public TreeNode recursion(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == preorder[0]) {
                int[] preorderLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] preorderRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                int[] inorderLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inorderRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                root.left = recursion(preorderLeft, inorderLeft);
                root.right = recursion(preorderRight, inorderRight);
                break;
            }
        }
        return root;
    }
}