# 核心思想：采用BFS
# 首先找到平方后不超过n的数字列表，然后从n开始遍历，将n入队
# 然后只要队不空，就弹出队列顶部的元素，并将该顶部元素的子节点入队
# 某一个节点的子节点为该节点减去数字列表平方后的值
# 减完后如果是0，则当前层数就是最短的长度


class Solution:
    def numSquares(self, n: int) -> int:
        max_square = int(pow(n, 0.5))
        num = list(range(max_square, 0, -1))
        queue = []
        step = 0
        queue.append(n)
        while len(queue) != 0:
            step += 1
            len_queue = len(queue)
            for i in range(len_queue):
                tmp = queue.pop(0)
                for j in num:
                    if tmp - j ** 2 == 0:
                        return step
                    if tmp - j ** 2 > 0:
                        queue.append(tmp - j ** 2)
        return 0


s = Solution()
res = s.numSquares()
print(res)