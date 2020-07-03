# 使用python的api
# 核心思想，将字符串分割split后存入List中，然后翻转reversed列表，最后采用“ ”joing连接
import collections


class Solution:
    def reverseWords(self, s: str) -> str:
        return " ".join(reversed(s.split()))


# 采用双端队列的思想
class Solution1:
    def reverseWords(self, s: str) -> str:
        i, j = 0, len(s) - 1
        while i < len(s) and s[i] == " ":
            i += 1
        while j >= 0 and s[j] == " ":
            j -= 1
        dq = collections.deque()
        word = []
        while i <= j:
            if s[i] == ' ' and word:
                dq.appendleft(''.join(word))
                word = []
            elif s[i] != ' ':
                word.append(s[i])
            i += 1
        dq.appendleft(''.join(word))
        return ' '.join(dq)


# 自己写api的方式
# 核心思想，首先将字符串整体翻转，然后从头遍历识别多余空格和单词，并将单词单独翻转
class Solution2:
    def reverseWords(self, s: str) -> str:
        if len(s) < 1:
            return s
        s = self.reverseWord(s, 0, len(s))
        res = ""
        end = 0
        while end < len(s):
            while end < len(s) and s[end] == ' ':
                end += 1
            start = end
            while end < len(s) and s[end] != ' ':
                end += 1
            res = res + self.reverseWord(s, start, end) + " "
        j = len(res) - 1
        while j >= 0 and res[j] == ' ':
            j -= 1
        return res[:j + 1]

    def reverseWord(self, s: str, start: int, end: int) -> str:
        tmp = s[start:end]
        tmp = tmp[::-1]
        return tmp

s = Solution1()
a = "  hello world !!!   "
b = s.reverseWords(a)
print(b)
