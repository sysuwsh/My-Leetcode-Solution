from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        i = 0
        while i < len(nums):
            while i < len(nums) and nums[i] != 0:
                i += 1
            j = i
            while j < len(nums) and nums[j] == 0:
                j += 1
            if i < len(nums) and j < len(nums):
                nums[i], nums[j] = nums[j], nums[i]
            if j >= len(nums):
                break

s = Solution()
nums = [1, 3, 12, 0, 0, 0]
s.moveZeroes(nums)
print(nums)
