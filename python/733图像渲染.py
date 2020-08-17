from typing import List


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        tmp = image[sr][sc]
        m = len(image)
        n = len(image[0])

        # 这里要注意，为了避免访问过的点又被重新访问，造成死循环，因此当newColor和原来的颜色一样的时候，直接返回原图就可以了
        # 否则话在这里要增加visited数组记录已经访问过的点
        # if len(image) == 0 or newColor == tmp:
        #     return image

        # 这里测试使用visited数组的方式，就不用多newColor == tmp这一步
        if len(image) == 0:
            return image
        visited = set()

        def bfs(graph, row, col, color):
            if row < 0 or row >= m or col < 0 or col >= n:
                return
            if graph[row][col] == tmp and ((row * n + col) not in visited):
                graph[row][col] = color
                visited.add(row * n + col)
            else:
                return
            bfs(graph, row - 1, col, color)
            bfs(graph, row, col + 1, color)
            bfs(graph, row + 1, col, color)
            bfs(graph, row, col - 1, color)

        bfs(image, sr, sc, newColor)
        return image


s = Solution()
image = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
image1 = [[0, 0, 0], [0, 1, 1]]
print(s.floodFill(image1, 1, 1, 1))
