from typing import List


# 不需要额外内存空间解法
class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)
        # 假设n为偶数，将左上角的n^2/4个元素组成的小矩阵作为一个遍历单位
        # 然后对于小矩阵中的每个元素，找到它们交换后的位置之间的关系，然后顺时针进行交换即可
        for i in range(n // 2):
            for j in range((n + 1) // 2):
                matrix[i][j], matrix[j][n - i - 1] = matrix[j][n - i - 1], matrix[i][j]
                matrix[i][j], matrix[n - i - 1][n - j - 1] = matrix[n - i - 1][n - j - 1], matrix[i][j]
                matrix[i][j], matrix[n - j - 1][i] = matrix[n - j - 1][i], matrix[i][j]


class Solution2:
    def rotate(self, matrix: List[List[int]]) -> None:
        # 翻转法
        # 由于M_new[col][n-row-1] = M[row][col]，因此思考如何能从M[row][col]通过翻转得到前者
        # 第一步，先沿着中心水平轴进行翻转，就得到了M[n-row-1][col]，再沿着对角线得到M[col][n-row-1]
        n = len(matrix)
        for i in range(n // 2):
            j = n - i - 1
            if i < j:
                for k in range(n):
                    matrix[i][k], matrix[j][k] = matrix[j][k], matrix[i][k]
        print(matrix)
        for i in range(n):
            for j in range(i + 1, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]


# 需要额外内存空间解法
class Solution3:
    def rotate(self, matrix: List[List[int]]) -> None:
        result = []
        for j in range(len(matrix)):
            tmp = []
            for i in range(len(matrix) - 1, -1, -1):
                tmp.append(matrix[i][j])
            result.append(tmp)
        matrix[:] = result

    def rotate1(self, matrix: List[List[int]]) -> None:
        n = len(matrix)
        tmp = [[0] * n for i in range(n)]
        for i in range(n):
            for j in range(n):
                tmp[j][n - i - 1] = matrix[i][j]
        matrix[:] = tmp


a = Solution2()
test = [
    [5, 1, 9, 11],
    [2, 4, 8, 10],
    [13, 3, 6, 7],
    [15, 14, 12, 16]
]
test1 = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]
a.rotate(test)
print(test)
