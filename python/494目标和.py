from typing import List


#  核心思想看java版本的代码
class Solution1:
    def findTargetSumWays(self, nums: List[int], S: int) -> int:
        sumNums = 0
        for n in nums:
            sumNums += n
        if sumNums < S or (sumNums + S) % 2 == 1:
            return 0
        return self.numOfSubset(nums, int((sumNums + S) / 2))

    def numOfSubset(self, nums, target):
        n = len(nums)
        dp = [[0 for _ in range(target + 1)] for _ in range(n + 1)]
        for i in range(n + 1):
            dp[i][0] = 1
        for i in range(1, n + 1):
            for j in range(target + 1):
                if j >= nums[i - 1]:
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]]
                else:
                    dp[i][j] = dp[i - 1][j]
        return dp[n][target]


# 采用dfs回溯的方式进行穷举，但是python版本的代码会超时
class Solution:
    def findTargetSumWays(self, nums: List[int], S: int) -> int:
        def dfs(nums, i, target, res):
            if i == len(nums):
                if target == 0:
                    res[0] += 1
                return
            dfs(nums, i + 1, target - nums[i], res)
            dfs(nums, i + 1, target + nums[i], res)

        res = [0]
        dfs(nums, 0, S, res)
        return res[0]


s = Solution1()
nums = [1]
target = 1
print(s.findTargetSumWays(nums, target))
