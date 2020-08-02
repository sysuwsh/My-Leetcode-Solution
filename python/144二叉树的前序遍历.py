from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# 递归的解法
class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        if root:
            self.preorder(root, res)
        return res

    def preorder(self, root, res):
        res.append(root.val)
        if root.left:
            self.preorder(root.left, res)
        if root.right:
            self.preorder(root.right, res)


# 迭代的解法
class Solution1:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        res = []
        stack = [root]
        while stack:
            cur = stack.pop()
            if cur:
                res.append(cur.val)
            if cur.right:
                stack.append(cur.right)
            if cur.left:
                stack.append(cur.left)
        return res

