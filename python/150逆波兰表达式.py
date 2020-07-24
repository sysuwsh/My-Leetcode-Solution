from typing import List
# 核心思想：后缀表达式求值
# 遇到数字则压栈，遇到运算符则弹出栈顶的两个数字进行运算，再将运算结果进行压栈


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        if len(tokens) == 0:
            return 0
        operate = {'+', '-', '*', '/'}
        stack = []
        for i in range(len(tokens)):
            if tokens[i] in operate and len(stack) > 1:
                first = stack.pop(len(stack) - 1)
                second = stack.pop(len(stack) - 1)
                if tokens[i] == '+':
                    stack.append(second + first)
                elif tokens[i] == '-':
                    stack.append(second - first)
                elif tokens[i] == '*':
                    stack.append(second * first)
                elif tokens[i] == '/':
                    # 注意这里的一个问题，不能使用//，因为//是两个数相除得到的结果向下取整
                    # 当出现复数的时候，例如6 / (-132) = -0.0454546，这个时候//得到的结果是-1
                    # 题目中要求的结果应该是0，所以要采用int()强转成整数型
                    stack.append(int(second / first))
            else:
                stack.append(int(tokens[i]))
        return stack[0]


s = Solution()
tokens = []
print(s.evalRPN(tokens))

