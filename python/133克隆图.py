from collections import deque


class Node:
    def __init__(self, val=0, neighbors=[]):
        self.val = val
        self.neighbors = neighbors


# 采用DFS的方式遍历图，没遇到一个节点，判断其是否访问过
# 访问过的话，直接返回第一次clone的对象，如果没有的话，创建新的对象，并加入到visited中
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        visited = {}

        def dfs(node):
            if not node:
                return
            if node in visited:
                return visited[node]
            clone = Node(node.val, [])
            visited[node] = clone
            for n in node.neighbors:
                clone.neighbors.append(dfs(n))
            return clone

        return dfs(node)


# 采用BFS的方式遍历图
class Solution1:
    def cloneGraph(self, node: 'Node') -> 'Node':
        visited = {}

        def bfs(node):
            if not node:
                return
            queue = deque()
            queue.append(node)
            clone = Node(node.val, [])
            visited[node] = clone
            while queue:
                tmp = queue.popleft()
                for n in tmp.neighbors:
                    if n not in visited:
                        visited[n] = Node(n.val, [])
                        queue.append(n)
                    visited[tmp].neighbors.append(visited[n])
            return clone

