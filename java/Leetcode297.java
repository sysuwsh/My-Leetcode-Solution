import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Leetcode297 {
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        serializeDFS(root, str);
        return str.toString();
    }

    public void serializeDFS(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("#,");
            return;
        }
        str.append(root.val).append(",");
        serializeDFS(root.left, str);
        serializeDFS(root.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> res = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeDFS(res);
    }

    public TreeNode deserializeDFS(LinkedList<String> res) {
        if (res.isEmpty())
            return null;
        String first = res.removeFirst();
        if (first.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserializeDFS(res);
        root.right = deserializeDFS(res);
        return root;
    }
}
