from collections import deque


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if root is None:
            return 0
        queue = deque()
        queue.append(root)
        depth = 1

        while queue:
            size = len(queue)
            for i in range(size):
                cur = queue.popleft()
                if cur.left is None and cur.right is None:
                    return depth
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
            depth += 1

        return depth
