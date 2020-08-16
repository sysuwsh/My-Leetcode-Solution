import java.util.*;

public class Leetcode111 {
    public static void main(String[] args) {

    }
}

class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            ++depth;
        }

        return depth;
    }
}


// 其实这个题需要visited来存储，因为二叉树不存在环，因此不必考虑visited
class Solution111_1 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < q.size(); ++i) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null)
                    return depth;
                if (cur.left != null && !visited.contains(cur.left)) {
                    q.offer(cur.left);
                    visited.add(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right)) {
                    q.offer(cur.right);
                    visited.add(cur.right);
                }
            }
            ++depth;
        }

        return depth;
    }
}