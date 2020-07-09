from typing import List


class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        nums.sort()
        res = 0
        for i in range(0, len(nums), 2):
            res += nums[i]
        return res


s = Solution()
nums = [1, 4, 2, 3]
res = s.arrayPairSum(nums)
print(res)
