class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# 递归的方式
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None or root == p or root == q:
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if left is None:
            return right
        if right is None:
            return left
        return root


# 采用DFS找路径的方式
class Solution1:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        def dfs(node, target, path, res, finish):
            if node is None or finish == 1:
                return
            path.append(node)
            if node == target:
                finish = 1
                for i in range(len(path)):
                    res.append(path[i])
            dfs(node.left, target, path, res, finish)
            dfs(node.right, target, path, res, finish)
            path.pop()

        path = []
        res1 = []
        res2 = []
        finish = 0
        dfs(root, p, path, res1, finish)
        path.clear()
        dfs(root, q, path, res2, finish)
        minLen = min(len(res1), len(res2))
        res = None
        for i in range(minLen):
            if res1[i] == res2[i]:
                res = res1[i]
        return res


root = TreeNode(3)
root.left = TreeNode(5)
root.right = TreeNode(1)
root.left.left = TreeNode(6)
root.left.right = TreeNode(2)
root.left.right.left = TreeNode(7)
root.left.right.right = TreeNode(4)
root.right.left = TreeNode(0)
root.right.right = TreeNode(8)

s = Solution1()
print(s.lowestCommonAncestor(root, root.left, root.right.left).val)
