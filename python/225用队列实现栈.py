class MyStack:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.queue1 = []
        self.queue2 = []

    def push(self, x: int) -> None:
        """
        Push element x onto stack.
        """
        self.queue1.append(x)


    def pop(self) -> int:
        """
        Removes the element on top of the stack and returns that element.
        """
        l = len(self.queue1)
        for i in range(l - 1):
            self.queue2.append(self.queue1.pop(0))
        res = self.queue1.pop(0)
        tmp = self.queue1
        self.queue1 = self.queue2
        self.queue2 = tmp
        return res

    def top(self) -> int:
        """
        Get the top element.
        """
        l = len(self.queue1)
        for i in range(l - 1):
            self.queue2.append(self.queue1.pop(0))
        res = self.queue1.pop(0)
        self.queue2.append(res)
        tmp = self.queue1
        self.queue1 = self.queue2
        self.queue2 = tmp
        return res


    def empty(self) -> bool:
        """
        Returns whether the stack is empty.
        """
        return len(self.queue1) == 0