# 使用辅助栈来存储每个元素压栈后当前的最小值
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min_stack = []

    def push(self, x: int) -> None:
        self.stack.append(x)
        if len(self.min_stack) == 0 or self.min_stack[len(self.min_stack) - 1] > x:
            self.min_stack.append(x)
        else:
            self.min_stack.append(self.min_stack[len(self.min_stack) - 1])

    def pop(self) -> None:
        self.stack.pop(len(self.stack) - 1)
        self.min_stack.pop(len(self.min_stack) - 1)

    def top(self) -> int:
        return self.stack[len(self.stack) - 1]

    def getMin(self) -> int:
        return self.min_stack[len(self.min_stack) - 1]