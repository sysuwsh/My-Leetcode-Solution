from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 0:
            return ""
        else:
            return self.dividePrefix(strs, 0, len(strs) - 1)

    def dividePrefix(self, strs: List[str], start: int, end: int):
        if start == end:
            return strs[start]
        else:
            mid = (end - start) // 2 + start
            leftStr = self.dividePrefix(strs, start, mid)
            rightStr = self.dividePrefix(strs, mid + 1, end)
            return self.mergePrefix(leftStr, rightStr)

    def mergePrefix(self, leftStr: str, rightStr: str):
        minLength = min(len(leftStr), len(rightStr))
        for i in range(minLength):
            if leftStr[i] != rightStr[i]:
                return leftStr[:i]
        return leftStr[:minLength]


class Solution1:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 0:
            return ""
        if len(strs) == 1:
            return strs[0]
        min_index = min(len(strs[0]), len(strs[1]))
        for i in range(len(strs) - 1):
            index = 0
            for j in range(min(min_index, min(len(strs[i + 1]), len(strs[i])))):
                if strs[i + 1][j] == strs[i][j]:
                    index += 1
                else:
                    break
            if index == 0:
                return ""
            if index < min_index:
                min_index = index
        return strs[0][:min_index]


class Solution2:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 0:
            return ""
        if len(strs) == 1:
            return strs[0]
        min_len = len(strs[0])
        for i in range(1, len(strs)):
            if len(strs[i]) < min_len:
                min_len = len(strs[i])
        bound = 0
        for j in range(min_len):
            flag = True
            for i in range(len(strs) - 1):
                if strs[i + 1][j] != strs[i][j]:
                    flag = False
                    break
            bound = j + 1
            if not flag:
                bound = j
                break
        return strs[0][:bound]


s = Solution()
test = ["flower", "flow", "flight"]
res = s.longestCommonPrefix(test)
print(res)
test1 = ["dog", "racecar", "car"]
res1 = s.longestCommonPrefix(test1)
print(res1)
test2 = ["aca", "cba"]
res2 = s.longestCommonPrefix(test2)
print(res2)
