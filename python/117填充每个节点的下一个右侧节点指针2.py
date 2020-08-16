class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


# 迭代的方法
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root is None:
            return None
        cur = root
        while cur:
            head = Node()  # 将每一层节点看做链表，然后为该链表创建头指针和尾指针，头指针无意义，只象征链表的开头
            tail = head  # 尾指针指向该链表的最后一个元素
            while cur:
                if cur.left:
                    tail.next = cur.left
                    tail = tail.next
                if cur.right:
                    tail.next = cur.right
                    tail = tail.next
                cur = cur.next
            cur = head.next  # 当cur要向下一层遍历的时候，cur就指向下一层的第一个元素，即下一层的链表的头指针的next
        return root


# 递归的方法
class Solution1:
    def connect(self, root: 'Node') -> 'Node':
        if root is None or (root.left is None and root.right is None):
            return root
        if root.left and root.right:
            root.left.next = root.right
            root.right.next = self.getNextNode(root)
        if root.left is None and root.right:
            root.right.next = self.getNextNode(root)
        if root.left and root.right is None:
            root.left.next = self.getNextNode(root)
        self.connect(root.right)  # 注意这里递归一定要先递归右子树，因为getNextNode函数是从左往右寻找的，如果右子树关系还没有建立起来就先递归左子树，就会报错
        self.connect(root.left)
        return root

    def getNextNode(self, root: 'Node') -> 'Node':
        while root.next:
            if root.next.left:
                return root.next.left
            if root.next.right:
                return root.next.right
            root = root.next
        return None
