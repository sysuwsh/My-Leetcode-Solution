import java.util.*;

public class Leetcode841 {
    public static void main(String[] args) {

    }
}

// dfs递归的方式
class Solution841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        dfs(rooms, 0, visited);
        return visited.size() == rooms.size();
    }

    public void dfs(List<List<Integer>> rooms, int roomIndex, Set<Integer> visited) {
        visited.add(roomIndex);
        for (Integer room: rooms.get(roomIndex)) {
            if (!visited.contains(room))
                dfs(rooms, room, visited);
        }
    }
}

// dfs迭代的方式
class Solution841_1 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        while (!stack.isEmpty()) {
            int roomIndex = stack.pop();
            for (Integer room: rooms.get(roomIndex)) {
                if (!visited.contains(room)) {
                    visited.add(room);
                    stack.add(room);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}

// bfs的方式
class Solution841_2 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int roomIndex = queue.poll();
            for (Integer room: rooms.get(roomIndex)) {
                if (!visited.contains(room)) {
                    visited.add(room);
                    queue.offer(room);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}