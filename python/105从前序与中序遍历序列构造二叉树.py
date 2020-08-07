from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if preorder is None or inorder is None:
            return None

        def recursion(preList, inList):
            if not preList:
                return None
            root = TreeNode(preList[0])
            index = inList.index(preList[0])
            root.left = recursion(preList[1:index + 1], inList[:index])
            root.right = recursion(preList[index + 1:], inList[index + 1:])
            return root

        return recursion(preorder, inorder)




