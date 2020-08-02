from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# 迭代的方式1
# 先序遍历的方式是：root->left->right
# 后序遍历的方式是：left->right->root
# 如果将先序遍历的顺序改为: root->right->left的话，那么就可以直接将先序遍历的结果反转得到后序遍历的结果
# 注意这里，后序遍历并不是先序遍历结果反过来就行，而是对先序遍历进行了改变
class Solution1:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        res = []
        stack = [root]
        while stack:
            cur = stack.pop()
            if cur:
                res.append(cur.val)
            if cur.left:
                stack.append(cur.left)
            if cur.right:
                stack.append(cur.right)
        return res[::-1]


# 严格的迭代方式
class Solution2:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        stack = []
        cur = root
        while cur or stack:
            while cur:
                stack.append(cur)
                if cur.left:
                    cur = cur.left
                else:
                    cur = cur.right
            cur = stack.pop()
            res.append(cur.val)
            if stack and stack[-1].left == cur:
                cur = stack[-1].right
            else:
                cur = None
        return res


# 递归的方式
class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        res = []
        self.postorder(root, res)
        return res

    def postorder(self, root, res):
        if root.left:
            self.postorder(root.left, res)
        if root.right:
            self.postorder(root.right, res)
        if root:
            res.append(root.val)
