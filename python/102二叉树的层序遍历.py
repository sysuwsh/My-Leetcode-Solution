from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# 采用队列实现层序遍历的一种方式
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return []
        queue = [root]
        res = [[root.val]]
        while queue:
            tmp = []
            size_queue = len(queue)
            for i in range(size_queue):
                cur = queue.pop(0)
                if cur.left:
                    tmp.append(cur.left.val)
                    queue.append(cur.left)
                if cur.right:
                    tmp.append(cur.right.val)
                    queue.append(cur.right)
            res.append(tmp)
        return res[:-1]  # 此处由于最后会添加一个空[]，所以需要删除最后一个空[]


# 采用递归实现的方式
class Solution1:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        ans = []
        self.recursion(root, 0, ans)
        return ans

    def recursion(self, root, depth, ans):
        if root is None:
            return
        if depth >= len(ans):
            ans.append([])
        ans[depth].append(root.val)
        self.recursion(root.left, depth + 1, ans)
        self.recursion(root.right, depth + 1, ans)
