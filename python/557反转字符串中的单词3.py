class Solution:
    def reverseWords(self, s: str) -> str:
        return ' '.join(self.reverse(x) for x in s.split())

    def reverse(self, s: str) -> str:
        l = list(s)
        return ''.join(l[-1::-1])


s = Solution()
res = s.reverseWords("fw")
print(res)
