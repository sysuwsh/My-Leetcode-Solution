public class Leetcode116 {
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


// 迭代的方法
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Node pre = root;
        while (pre.left != null) {
            Node tmp = pre;
            while (tmp != null) {
                tmp.left.next = tmp.right;
                if (tmp.next != null)
                    tmp.right.next = tmp.next.left;
                tmp = tmp.next;
            }
            pre = pre.left;
        }
        return root;
    }
}

// 递归的方式
class Soultion1 {
    public Node connect(Node root) {
        if (root == null)
            return null;
        dfs(root);
        return root;
    }

    public void dfs(Node root) {
        if (root == null)
            return;
        Node left = root.left;
        Node right = root.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        dfs(root.left);
        dfs(root.right);
    }
}