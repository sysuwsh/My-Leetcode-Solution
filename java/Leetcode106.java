import java.util.Arrays;
import java.util.Map;

public class Leetcode106 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;}
}

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;
        return recursion(inorder, postorder);
    }

    public TreeNode recursion(int[] inorder, int[] postorder) {
        if (postorder.length == 0)
            return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                int[] inorderLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inorderRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                int[] postorderLeft = Arrays.copyOfRange(postorder, 0, i);
                int[] postorderRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);
                root.left = recursion(inorderLeft, postorderLeft);
                root.right = recursion(inorderRight, postorderRight);
                break;  
            }
        }
        return root;
    }
}
