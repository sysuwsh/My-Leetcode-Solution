import java.util.ArrayList;

public class Leetcode236 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        Solution236 s = new Solution236();
        TreeNode res = s.lowestCommonAncestor(root, root.left.left, root.left.right);
        System.out.println(res.val);
    }
}

// 公共祖先的概念：如果root是p和q的祖先，那么要么p和q在root的两侧，要么p==root或者q==root
// 当其中一个不在树内的话，则另一个就是最近公共祖先

// 递归解法
class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }
}

// 采用dfs搜索路径，然后比较路径得到
class Solution236_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path = new ArrayList<>();
        ArrayList<TreeNode> resP = new ArrayList<>();
        ArrayList<TreeNode> resQ = new ArrayList<>();
        int finish = 0;
        dfs(root, p, path, resP, finish);
        path.clear();
        dfs(root, q, path, resQ, finish);

        int len = Math.min(resP.size(), resQ.size());
        TreeNode res = null;
        for (int i = 0; i < len; i++) {
            if (resP.get(i) == resQ.get(i))
                res = resP.get(i);
        }
        return res;
    }

    public void dfs(TreeNode root, TreeNode target, ArrayList<TreeNode> path, ArrayList<TreeNode> res, int finish) {
        if (root == null || finish == 1)
            return;
        path.add(root);
        if (root == target) {
            finish = 1;
            res.addAll(path);
        }
        dfs(root.left, target, path, res, finish);
        dfs(root.right, target, path, res, finish);
        path.remove(path.size() - 1);
    }
}





