from typing import List


# 采用递归的思想
class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        if rowIndex == 0:
            return [1]
        if rowIndex == 1:
            return [1, 1]
        last = self.getRow(rowIndex - 1)
        res = [1] + [0] * (rowIndex - 1) + [1]
        for j in range(1, rowIndex):
            res[j] = last[j - 1] + last[j]
        return res


class Solution1:
    def getRow(self, rowIndex: int) -> List[int]:
        res = [0] * (rowIndex + 1)
        for i in range(rowIndex + 1):
            res[i] = 1
            for j in range(i, 1, -1):
                res[j - 1] = res[j - 2] + res[j - 1]
        return res


s = Solution1()
print(s.getRow(3))