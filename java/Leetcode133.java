import java.util.*;

public class Leetcode133 {
    public static void main(String[] args) {

    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

// 采用DFS的方式遍历图
class Solution1 {
    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }

    public Node dfs(Node node, Map<Node, Node> visited) {
        if (node == null)
            return null;
        if (visited.containsKey(node))
            return visited.get(node);
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone);
        for (Node n: node.neighbors) {
            clone.neighbors.add(dfs(n, visited));
        }
        return clone;
    }
}

// 采用BFS的方式遍历图
class Solution2 {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        Node clone = new Node(node.val, new ArrayList<>());
        Map<Node, Node> visited = new HashMap<>();
        visited.put(node, clone);
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            for (Node n: tmp.neighbors) {
                if (!visited.containsKey(n)) {
                    visited.put(n, new Node(n.val, new ArrayList<>()));
                    queue.offer(n);
                }
                visited.get(tmp).neighbors.add(visited.get(n));
            }
        }
        return clone;
    }
}
