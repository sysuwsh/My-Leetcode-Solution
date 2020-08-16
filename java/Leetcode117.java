public class Leetcode117 {
}

// 迭代的解法
class Solution117 {
    public Node connect(Node root) {
        if (root == null)
            return null;
        Node cur = root;
        while (cur != null) {
            Node head = new Node();
            Node tail = head;
            while (cur != null) {
                if (cur.left != null) {
                    tail.next = cur.left;
                    tail = tail.next;
                }
                if (cur.right != null) {
                    tail.next = cur.right;
                    tail = tail.next;
                }
                cur = cur.next;
            }
            cur = head.next;
        }
        return root;
    }
}

// 递归的解法
class Solution117_1 {
    public Node connect(Node root) {
        if (root == null || root.left == null && root.right == null)
            return root;
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = getNextNode(root);
        }
        if (root.left == null) {
            root.right.next = getNextNode(root);
        }
        if (root.right == null) {
            root.left.next = getNextNode(root);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    public Node getNextNode(Node root) {
        while (root.next != null) {
            if (root.next.left != null)
                return root.next.left;
            if (root.next.right != null)
                return root.next.right;
            root = root.next;
        }
        return null;
    }
}