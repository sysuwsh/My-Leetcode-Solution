# 使用栈来处理
class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        num = 0
        res = ''
        for i in range(len(s)):
            if s[i] == '[':
                stack.append([num, res])
                num = 0
                res = ''
            elif s[i] == ']':
                cur_num, pre_str = stack.pop()
                res = pre_str + res * cur_num
            elif '0' <= s[i] <= '9':
                num = num * 10 + int(s[i])
            else:
                res += s[i]
        return res


# 递归的方法
class Solution1:
    def decodeString(self, s: str) -> str:
        def dfs(i):
            res = ''
            num = 0
            while i < len(s):
                if '0' <= s[i] <= '9':
                    num = num * 10 + int(s[i])
                elif s[i] == '[':
                    i, tmp = dfs(i + 1)
                    res += tmp * num
                    num = 0
                elif s[i] == ']':
                    return i, res
                else:
                    res += s[i]
                i += 1
            return res

        return dfs(0)


s = Solution1()
a = "3[a2[c]]"
print(s.decodeString(a))