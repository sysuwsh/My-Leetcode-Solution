import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Vector;

public class Leetcode200 {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        Solution200 s = new Solution200();
        System.out.println(s.numIslands(grid));
    }
}

// 并查集的解法
class Solution200 {
    private class Union {
        private int[] parent;
        private int count = 0;

        Union(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    parent[i * n + j] = -1;
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                }
            }
        }

        public int find(int a) {
            if (parent[a] != a) {
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX != parentY) {
                parent[parentY] = parentX;
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        final int[][] direction = new int[][]{{0, 1}, {1, 0}};
        Union u = new Union(grid);

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    for (int[] ints : direction) {
                        int new_i = i + ints[0];
                        int new_j = j + ints[1];
                        if (new_i < m && new_j < n && grid[new_i][new_j] == '1') {
                            u.union(i * n + j, new_i * n + new_j);
                        }
                    }
                }
            }
        }

        return u.getCount();
    }
}


// BFS的解法，我这里的队列存储的是每个项的坐标了，为了节省空间其实可以采用一个数来表示坐标，利用 x * m + y 得到每个坐标对应的数就可以
class Solution200_1 {
    private final int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        boolean[][] marked = new boolean[m][n];
        int count = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    queue.offer(new int[]{i, j});
                    marked[i][j] = true;
                    ++count;
                    while (!queue.isEmpty()) {
                        for (int[] ints : direction) {
                            int new_i = queue.peek()[0] + ints[0];
                            int new_j = queue.peek()[1] + ints[1];
                            if (0 <= new_i && new_i < m && 0 <= new_j && new_j < n && !marked[new_i][new_j] && grid[new_i][new_j] == '1') {
                                queue.offer(new int[]{new_i, new_j});
                                marked[new_i][new_j] = true;
                            }
                        }
                        queue.poll();
                    }
                }
            }
        }

        return count;
    }
}


// DFS的解法
class Solution200_2 {
    private final int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        boolean[][] marked = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j< n; ++j) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    ++count;
                    dfs(i, j, m, n, marked, grid);
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, int m, int n, boolean[][] marked, char[][] grid) {
        marked[i][j] = true;
        for (int d = 0; d < direction.length; ++d) {
            int new_i = i + direction[d][0];
            int new_j = j + direction[d][1];
            if (0 <= new_i && new_i < m && 0 <= new_j && new_j < n && !marked[new_i][new_j] && grid[new_i][new_j] == '1') {
                dfs(new_i, new_j, m, n, marked, grid);
            }
        }
    }
}