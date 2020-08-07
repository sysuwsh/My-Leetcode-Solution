from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if not (inorder and postorder):
            return None

        def recursion(inList, postList):
            if not postList:
                return None
            root = TreeNode(postList[-1])
            index = inList.index(postList[-1])
            root.left = recursion(inList[:index], postList[:index])
            root.right = recursion(inList[index + 1:], postList[index:-1])
            return root

        return recursion(inorder, postorder)
