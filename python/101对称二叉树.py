class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# 递归的方式
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True

        def recursion(left, right):
            if left is None and right is None:
                return True
            if left is None or right is None:
                return False
            if left.val != right.val:
                return False
            return recursion(left.left, right.right) and recursion(left.right, right.left)

        return recursion(root.left, root.right)


# 迭代的方式，采用队列解决
class Solution1:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None or (root.left is None and root.right is None):
            return True

        queue = [root.left, root.right]

        while queue:
            leftNode = queue.pop(0)
            rightNode = queue.pop(0)
            if leftNode is None and rightNode is None:
                continue
            if leftNode is None or rightNode is None:
                return False
            if leftNode.val != rightNode.val:
                return False
            queue.append(leftNode.left)
            queue.append(rightNode.right)
            queue.append(leftNode.right)
            queue.append(rightNode.left)

        return True
