from typing import List

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) == 0:
            return 0
        i, j = 0, 0
        n = self.build_next(needle)
        while i < len(haystack) and j < len(needle):
            if j < 0 or haystack[i] == needle[j]:
                i += 1
                j += 1
            else:
                j = n[j]
        if j == len(needle):
            return i - j
        else:
            return -1

    def build_next(self, p: str) -> List:
        if len(p) == 0:
            return []
        str_len = len(p)
        n = [0] * str_len
        n[0] = -1
        j = 0
        t = n[0]
        while j < str_len - 1:
            if t < 0 or p[j] == p[t]:
                t += 1
                j += 1
                n[j] = t
            else:
                t = n[t]
        return n


a = Solution()
haystack = ""
needle = "aaa"
start = a.strStr(haystack, needle)
print(start)