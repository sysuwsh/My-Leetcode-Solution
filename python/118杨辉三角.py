from typing import List


class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = []
        for i in range(1, numRows + 1):
            tmp = [0] * i
            for j in range(i):
                if j == 0 or j == i - 1:
                    tmp[j] = 1
                else:
                    tmp[j] = res[i - 2][j - 1] + res[i - 2][j]
            res.append(tmp)
        return res


s = Solution()
print(s.generate(5))
