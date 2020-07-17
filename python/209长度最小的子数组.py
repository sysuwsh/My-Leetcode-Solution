from typing import List


class Solution:
    def minSubArrayLen(self, s: int, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        start, end = 0, 0
        num_sum = 0
        min_len = len(nums) + 1
        while end < len(nums):
            num_sum += nums[end]
            while num_sum >= s:
                min_len = min(min_len, end - start + 1)
                num_sum -= nums[start]
                start += 1
            end += 1
        return 0 if min_len == len(nums) + 1 else min_len


s = Solution()
nums = [1, 1, 1, 1, 100]
res = s.minSubArrayLen(7, nums)
print(res)
