from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# 迭代的方式
class Solution1:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        stack = []
        cur = root
        res = []
        while cur or len(stack) > 0:
            while cur:
                stack.append(cur)
                cur = cur.left
            cur = stack.pop(len(stack) - 1)
            res.append(cur.val)
            cur = cur.right
        return res

# 递归的方式
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        res = []
        self.recursion(root, res)
        return res

    def recursion(self, root, res):
        if root.left is not None:
            self.recursion(root.left, res)
        res.append(root.val)
        if root.right is not None:
            self.recursion(root.right, res)
