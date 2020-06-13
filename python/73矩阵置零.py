from typing import List


# 不需要额外空间的解法
class Solution:
    def setZeros(self, matrix: List[List[int]]) -> None:
        row_flag = False
        col_flag = False
        # row_flag和col_flag用来记录第一行和第一列是否有0元素出现
        for i in range(len(matrix)):
            if matrix[i][0] == 0:
                col_flag = True
                break
        for j in range(len(matrix[0])):
            if matrix[0][j] == 0:
                row_flag = True
                break
        # 遍历除第一行第一列外的剩下元素，将0元素出现的地方标记在第一行和第一列对应的位置上
        for i in range(1, len(matrix)):
            for j in range(1, len(matrix[0])):
                if matrix[i][j] == 0:
                    matrix[i][0] = 0
                    matrix[0][j] = 0
        # 开始置0
        for i in range(1, len(matrix)):
            if matrix[i][0] == 0:
                for j in range(len(matrix[0])):
                    matrix[i][j] = 0
        for j in range(1, len(matrix[0])):
            if matrix[0][j] == 0:
                for i in range(len(matrix)):
                    matrix[i][j] = 0
        # 最后判断第一行和第一列是否需要置0
        if row_flag:
            for j in range(len(matrix[0])):
                matrix[0][j] = 0
        if col_flag:
            for i in range(len(matrix)):
                matrix[i][0] = 0


# 需要额外空间，空间复杂度为O(m+n),时间复杂度为O(m*n)
class Solution1:
    def setZeros(self, matrix: List[List[int]]) -> None:
        index_zero = []

        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if matrix[i][j] == 0:
                    index_zero.append([i, j])

        for index in index_zero:
            for col in range(len(matrix[index[0]])):
                matrix[index[0]][col] = 0
            for row in range(len(matrix)):
                matrix[row][index[1]] = 0


s = Solution()
test = [[1, 1, 1],
        [1, 0, 1],
        [1, 1, 1]]
test1 = [[0, 1, 2, 0],
         [3, 4, 5, 2],
         [1, 3, 1, 5]]
test2 = [[1, 0, 3]]
# s.setZeros(test)
s.setZeros(test2)
# print(test)
print(test2)
