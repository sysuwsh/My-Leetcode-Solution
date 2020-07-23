from typing import List


# 采用单调栈来解决
# 将T中每个元素的下标入栈或出栈
# 如果当前待入栈下标对应的温度要大于栈顶元素对应的温度，则栈顶元素对应的结果就是当前待入栈元素下标-栈顶元素
# 使得栈成为一个单调递减的栈（即栈中元素从栈顶到栈尾是递减的）
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        res = [0] * len(T)
        stack = []
        for i in range(len(T)):
            while stack and T[i] > T[stack[len(stack) - 1]]:
                res[stack[len(stack) - 1]] = i - stack[len(stack) - 1]
                stack.pop(len(stack) - 1)
            stack.append(i)
        return res


# 该解法超时
class Solution1:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        res = [0] * len(T)
        for i in range(len(T) - 1):
            for j in range(i + 1, len(T)):
                if T[j] > T[i]:
                    res[i] = j - i
                    break
        return res


s = Solution()
t = [73, 74, 75, 71, 69, 72, 76, 73]
print(s.dailyTemperatures(t))

