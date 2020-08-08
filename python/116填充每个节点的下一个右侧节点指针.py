class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


# 递归的方式，注意递归中解决问题的方式，是从中间最紧密的部分进行递归操作的
class Solution2:
    def connect(self, root: 'Node') -> 'Node':
        if root is None:
            return root

        def dfs(node):
            if node is None:
                return
            nodeLeft = node.left
            nodeRight = node.right
            while nodeLeft:
                nodeLeft.next = nodeRight
                nodeLeft = nodeLeft.right
                nodeRight = nodeRight.left
            dfs(node.left)
            dfs(node.right)

        dfs(root)
        return root

# 采用迭代的方式，注意跨父节点连接时，连接方式为:node.right.next = node.next.left
class Solution1:
    def connect(self, root: 'Node') -> 'Node':
        if root is None:
            return root
        tmp = root
        while tmp.left:
            cur = tmp
            while cur:
                cur.left.next = cur.right
                if cur.next:
                    cur.right.next = cur.next.left
                cur = cur.next
            tmp = tmp.left
        return root


# 该方法需要O(n)的空间复杂度，不符合题目要求
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root is None or (root.left is None and root.right is None):
            return root
        queue = [root.left, root.right]

        while queue:
            size = len(queue)
            for i in range(size):
                cur = queue.pop(0)
                if i < size - 1:
                    cur.next = queue[0]
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)

        return root

