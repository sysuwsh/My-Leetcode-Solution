class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# 采用自顶向下，dfs的方式
class Solution:
    ans = 0

    def maxDepth(self, root: TreeNode) -> int:
        def recursion(node, depth):
            if node is None:
                return
            if node.left is None and node.right is None:
                self.ans = max(self.ans, depth)
            recursion(node.left, depth + 1)
            recursion(node.right, depth + 1)

        recursion(root, 1)
        return self.ans


# 采用自底向上的方式
class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        def recursion(node):
            if node is None:
                return 0
            leftDepth = recursion(node.left)
            rightDepth = recursion(node.right)
            return max(leftDepth, rightDepth) + 1

        return recursion(root)
