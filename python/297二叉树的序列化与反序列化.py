class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        def serializeDFS(node, r):  # 这里注意一个错误，不能将r作为字符串传进去，因为str类型是不可变对象，不可变对象作为参数传递时，相当于值传递，而可变对象作为参数传递时，相当于引用传递
            if node is None:
                r.append("#")
                return
            r.append(str(node.val))
            serializeDFS(node.left, r)
            serializeDFS(node.right, r)

        res = []
        serializeDFS(root, res)
        return ','.join(res)

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        d = data.split(",")

        def deserializeDFS(res):
            if len(res) == 0:
                return None
            first = res.pop(0)
            if first == "#":
                return None
            root = TreeNode(int(first))
            root.left = deserializeDFS(res)
            root.right = deserializeDFS(res)
            return root

        return deserializeDFS(d)
