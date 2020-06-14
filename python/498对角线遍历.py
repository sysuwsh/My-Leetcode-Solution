from typing import List


# 核心思想，对角线上的下标之和为一定值
# 因此可以采用 x + y = value（定值）
# 向斜上遍历的时候，x-- (x >= 0)，y++ (y < n) n为列
# 向斜下遍历的时候，y-- (y <= 0)，x++ (x < m) m为行
class Solution:
    def findDiagonalOrder(self, matrix: List[List[int]]) -> List[int]:
        m = len(matrix)
        n = len(matrix[0])
        max_num = m + n - 1
        i = 0
        if not matrix:
            return []
        result = []
        while i < max_num:
            x1 = i if i < m else m - 1
            y1 = i - x1
            while x1 >= 0 and y1 < n:
                result.append(matrix[x1][y1])
                x1 -= 1
                y1 = i - x1
            i += 1

            if i >= max_num:
                break

            y2 = i if i < n else n - 1
            x2 = i - y2
            while x2 < m and y2 >= 0:
                result.append(matrix[x2][y2])
                y2 -= 1
                x2 = i - y2
            i += 1
        return result


s = Solution()
test = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]
res = s.findDiagonalOrder(test)
print(res)
