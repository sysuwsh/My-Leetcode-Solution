class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stackIn = []
        self.stackOut = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stackIn.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.stackOut) == 0:
            while self.stackIn:
                self.stackOut.append(self.stackIn.pop())
        return self.stackOut.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.stackOut) == 0:
            while self.stackIn:
                self.stackOut.append(self.stackIn.pop())
        return self.stackOut[len(self.stackOut) - 1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.stackIn) == 0 and len(self.stackOut) == 0:
            return True
        return False


s = MyQueue()
s.push(1)
s.push(2)
s.push(3)
s.pop()
s.pop()
print(s.peek())
print(s.empty())
