class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) == 0:
            return True
        l = list(s)
        stack = [l[0]]
        i = 1
        for i in range(1, len(l)):
            if l[i] == '[' or l[i] == '(' or l[i] == '{':
                stack.append(l[i])
            elif stack and l[i] == ']' and stack[len(stack) - 1] == '[':
                stack.pop(len(stack) - 1)
            elif stack and l[i] == ')' and stack[len(stack) - 1] == '(':
                stack.pop(len(stack) - 1)
            elif stack and l[i] == '}' and stack[len(stack) - 1] == '{':
                stack.pop(len(stack) - 1)
            else:
                return False
        if len(stack) == 0:
            return True
        else:
            return False


s = Solution()
a = "{[[]]}"
print(s.isValid(a))
