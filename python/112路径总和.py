class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# 注意一个观点：就是从sum倒着往回减的过程，一直到0
class Solution:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        if root is None:
            return False
        if root.left is None and root.right is None:
            return sum == 0
        return self.hasPathSum(root.left, sum - root.val) or self.hasPathSum(root.right, sum - root.val)


# 使用栈实现DFS
class Solution1:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        if root is None:
            return False
        stack = [(root, root.val)]
        while stack:
            node, path = stack.pop()
            if path == sum and node.left is None and node.right is None:
                return True
            if node.right:
                stack.append((node.right, path + node.right.val))
            if node.left:
                stack.append((node.left, path + node.left.val))
        return False


# 使用队列实现BFS
# 此方法多加了额外的记录路径的功能
class Solution2:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        if root is None:
            return False
        queue = [[root, root.val, [root.val, ]]]
        while queue:
            node, path, step = queue.pop(0)
            if path == sum and node.left is None and node.right is None:
                print(step)
                return True
            if node.left:
                queue.append([node.left, path + node.left.val, step + [node.left.val]])
            if node.right:
                queue.append([node.right, path + node.right.val, step + [node.right.val]])
        return False


root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)
root.right.left = TreeNode(6)
root.right.right = TreeNode(7)

s = Solution2()
s.hasPathSum(root, 8)
