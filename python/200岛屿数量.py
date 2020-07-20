from typing import List


# 采用并查集的方法
class Solution:
    # 首先定义一个并查集内部类
    class Union:
        def __init__(self, grid):
            m, n = len(grid), len(grid[0])
            self.count = 0  # count是记录有多少个类别的
            self.parent = [-1] * (m * n)  # parent是一个前导数据，记录着每一项的上一级是谁
            self.rank = [0] * (m * n)  # rank是每一项的等级，合并的时候，等级大的作为等级小的上级，相等的话任意都可
            for i in range(m):
                for j in range(n):
                    if grid[i][j] == '1':
                        self.parent[i * n + j] = i * n + j  # 初始化时候将所有的陆地元素的上级初始化为自身，而所有的水域元素的上级默认为0
                        self.count += 1  # 这里count记录下了所有的陆地有多少种（把水域排除在外了）

        # 对于x，find函数找到x的上一级是谁，采用递归查找的方式，直接找到最终的Boss是谁
        def find(self, x):
            if self.parent[x] != x:
                self.parent[x] = self.find(self.parent[x])
            return self.parent[x]

        # 对于两个项x和y，合并它们，本质上就是将他们的上级合并，合并的方式就是让其中一个成为另一个的上级即可
        # 至于谁成为谁的上级，就看谁的rank高了
        def union(self, x, y):
            rootx = self.find(x)
            rooty = self.find(y)
            if rootx != rooty:
                if self.rank[rootx] < self.rank[rooty]:
                    rootx, rooty = rooty, rootx
                self.parent[rooty] = rootx
                if self.rank[rootx] == self.rank[rooty]:
                    self.rank[rootx] += 1
                self.count -= 1

        def getCount(self):
            return self.count

    def numIslands(self, grid:List[List[str]]) -> int:
        m = len(grid)
        if m == 0:
            return 0
        n = len(grid[0])

        union = self.Union(grid)
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    grid[i][j] = '0'
                    for x, y in [(i, j + 1), (i + 1, j)]:
                        if x < m and y < n and grid[x][y] == '1':
                            union.union(i * n + j, x * n + y)

        return union.getCount()


# 采用BFS的方法
class Solution1:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid) == 0:
            return 0
        n = len(grid)
        m = len(grid[0])
        marked = [[False for _ in range(m)] for _ in range(n)]
        count = 0
        direction = [(-1, 0), (0, 1), (1, 0), (0, -1)]
        queue = []

        for i in range(n):
            for j in range(m):
                if not marked[i][j] and grid[i][j] == '1':
                    count += 1
                    queue.append((i, j))
                    marked[i][j] = True
                    while len(queue) > 0:
                        for d in direction:
                            new_i = queue[0][0] + d[0]
                            new_j = queue[0][1] + d[1]
                            if 0 <= new_i < n and 0 <= new_j < m and not marked[new_i][new_j] and grid[new_i][new_j] == '1':
                                queue.append((new_i, new_j))
                                marked[new_i][new_j] = True
                        queue.pop(0)

        return count


# 采用DFS的方法
class Solution2:
    direction = [(-1, 0), (0, 1), (1, 0), (0, -1)]  # 通过加direction来移动方向，方向默认顺序为：上、右、下、左

    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid) == 0:
            return 0
        n = len(grid)  # 行数
        m = len(grid[0])  # 列数
        marked = [[False for _ in range(m)] for _ in range(n)]
        count = 0  # count是记录连通分量的个数，本质上就是岛屿的数量

        for i in range(n):
            for j in range(m):
                if not marked[i][j] and grid[i][j] == '1':
                    count += 1
                    self._dfs(i, j, n, m, grid, marked)

        return count

    def _dfs(self, i: int, j: int, n: int, m: int, grid: List[List[str]], marked: List[List[bool]]):
        marked[i][j] = True
        for d in self.direction:
            new_i = i + d[0]
            new_j = j + d[1]
            if 0 <= new_i < n and 0 <= new_j < m and not marked[new_i][new_j] and grid[new_i][new_j] == '1':
                self._dfs(new_i, new_j, n, m, grid, marked)


s = Solution()
grid = [
    ['1', '1', '0', '0', '0'],
    ['1', '1', '0', '0', '0'],
    ['0', '0', '1', '0', '0'],
    ['0', '0', '0', '1', '1']
]
print(s.numIslands(grid))
