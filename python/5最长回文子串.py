from typing import Tuple, List, Union


class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s) < 2:
            return s
        tmp = [0, 0]  # tmp[0]存储起始位置 tmp[1]存储字符串最大长度
        for i in range(len(s) - 1):
            self.findPalindrome(s, i, i, tmp)
            self.findPalindrome(s, i, i + 1, tmp)
        return s[tmp[0]:tmp[0] + tmp[1]]

    def findPalindrome(self, s: str, left: int, right: int, tmp: List):
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        if right - left - 1 > tmp[1]:
            tmp[1] = right - left - 1
            tmp[0] = left + 1

# 动态规划解法 核心思想:如果一个字符串头和尾相等，且中间部分也为回文串，那么该字符串就是回文串
# 状态转移方程：if s[i] == s[j] and dp[i + 1][j - 1] == True 则dp[i][j] = True
# 边界条件：单个字符一定是回文串，if j - i < 3（即头尾两个字符的中间部分要么是空的要么只有一个的时候）,那么只需要头尾相等就可以了
class Solution1:
    def longestPalindrome(self, s: str) -> str:
        s_len = len(s)
        if s_len == 0:
            return ""
        dp = [[0 for _ in range(s_len)] for _ in range(s_len)]
        for i in range(s_len):
            dp[i][i] = 1
        for j in range(1, s_len):
            for i in range(0, j):
                if s[i] == s[j] and j - i < 3:
                    dp[i][j] = j - i + 1
                elif s[i] == s[j] and dp[i + 1][j - 1] != 0:
                    dp[i][j] = j - i + 1
        index_i = 0
        index_j = 0
        max_now = dp[0][0]
        for i in range(s_len):
            for j in range(i, s_len):
                if dp[i][j] > max_now:
                    max_now = dp[i][j]
                    index_i = i
                    index_j = j
        return s[index_i:index_j + 1]



class Solution3:
    def longestPalindrome(self, s: str) -> str:
        if s is None or len(s) == 0:
            return ""
        res = s[0]
        for str_num in range(2, len(s) + 1):
            for i in range(len(s) - str_num + 1):
                if self.isPalindrome(s[i:i + str_num]):
                    res = s[i:i + str_num]
                    break
        return res

    def isPalindrome(self, s: str) -> bool:
        i = 0
        j = len(s) - 1
        while i <= j:
            if s[i] != s[j]:
                return False
            i += 1
            j -= 1
        return True


s = Solution()
a = "aaaa"
a = s.longestPalindrome(a)
print(a)
