import java.util.*;

public class Leetcode133 {
    public static void main(String[] args) {

    }
}

class Node2 {
    public int val;
    public List<Node2> neighbors;

    public Node2() {
        val = 0;
        neighbors = new ArrayList<Node2>();
    }

    public Node2(int _val) {
        val = _val;
        neighbors = new ArrayList<Node2>();
    }

    public Node2(int _val, ArrayList<Node2> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

// 采用DFS的方式遍历图
class Solution133 {
    public Node2 cloneGraph(Node2 Node2) {
        Map<Node2, Node2> visited = new HashMap<>();
        return dfs(Node2, visited);
    }

    public Node2 dfs(Node2 Node2, Map<Node2, Node2> visited) {
        if (Node2 == null)
            return null;
        if (visited.containsKey(Node2))
            return visited.get(Node2);
        Node2 clone = new Node2(Node2.val, new ArrayList<>());
        visited.put(Node2, clone);
        for (Node2 n: Node2.neighbors) {
            clone.neighbors.add(dfs(n, visited));
        }
        return clone;
    }
}

// 采用BFS的方式遍历图
class Solution133_2 {
    public Node2 cloneGraph(Node2 Node2) {
        if (Node2 == null)
            return null;
        Queue<Node2> queue = new LinkedList<>();
        queue.offer(Node2);
        Node2 clone = new Node2(Node2.val, new ArrayList<>());
        Map<Node2, Node2> visited = new HashMap<>();
        visited.put(Node2, clone);
        while (!queue.isEmpty()) {
            Node2 tmp = queue.poll();
            for (Node2 n: tmp.neighbors) {
                if (!visited.containsKey(n)) {
                    visited.put(n, new Node2(n.val, new ArrayList<>()));
                    queue.offer(n);
                }
                visited.get(tmp).neighbors.add(visited.get(n));
            }
        }
        return clone;
    }
}
