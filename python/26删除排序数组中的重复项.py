from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0 or len(nums) == 1:
            return len(nums)
        i, j = 0, 1
        while j < len(nums):
            while j < len(nums) and nums[j] == nums[i]:
                j += 1
            if j < len(nums):
                nums[i + 1] = nums[j]
            i += 1
        return i


s = Solution()
nums = [1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4]
end = s.removeDuplicates(nums)
print(end)
print(nums[0:end])
