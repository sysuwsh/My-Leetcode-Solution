from typing import List
from collections import deque


# 采用双向BFS的方式，相对单向BFS来说要快很多
class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        def neighbor(s: str) -> str:
            for i in range(4):
                for j in (-1, 1):
                    yield s[:i] + str((int(s[i]) + j) % 10) + s[i + 1:]

        dead = set(deadends)
        queue1, queue2, visited = set(), set(), set()
        queue1.add("0000")
        queue2.add(target)
        step = 0

        while queue1 and queue2:
            tmp = set()
            for cur in queue1:
                if cur in dead:
                    continue
                if cur in queue2:
                    return step
                visited.add(cur)
                for nei in neighbor(cur):
                    if nei not in visited:
                        tmp.add(nei)
            step += 1
            queue1 = queue2
            queue2 = tmp

        return -1


# 注意这里做的优化：将deadends转为set提高查找效率
# 将visited采用set存储
# 这里注意python中的一个语法，对于集合set来说，{}可以生成集合，和字典不同的是，没有value值
# 以及，当要生成一个空的集合时，采用set()生成，{}默认生成的是空字典
class Solution1:
    def openLock(self, deadends: List[str], target: str) -> int:
        dead = set(deadends)
        visited = {"0000"}
        queue = deque()
        queue.append("0000")
        step = 0

        while queue:
            size = len(queue)
            for i in range(size):
                cur = queue.popleft()
                if cur in dead:
                    continue
                if cur == target:
                    return step
                for j in range(4):
                    up = self.plusOne(cur, j)
                    if up not in visited:
                        queue.append(up)
                        visited.add(up)
                    down = self.minusOne(cur, j)
                    if down not in visited:
                        queue.append(down)
                        visited.add(down)
            step += 1

        return -1

    def plusOne(self, s: str, index: int) -> str:
        l = list(s)
        if l[index] == '9':
            l[index] = '0'
        else:
            l[index] = str(int(l[index]) + 1)
        return ''.join(l)

    def minusOne(self, s: str, index: int) -> str:
        l = list(s)
        if l[index] == '0':
            l[index] = '9'
        else:
            l[index] = str(int(l[index]) - 1)
        return ''.join(l)


s = Solution()
deadends = ["0201", "0101", "0102", "1212", "2002"]
target = "0202"
print(s.openLock(deadends, target))
