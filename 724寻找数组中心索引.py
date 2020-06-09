from typing import List


class Solution:
    # 切片方法
    def pivotIndex(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            left = sum(nums[0:i])
            right = sum(nums[i+1:])
            if left == right:
                return i
        return -1

    # 判断前i个和是否等于总和的一半
    def pivotIndex1(self, nums: List[int]) -> int:
        total = sum(nums)
        left_sum = 0
        for i in range(len(nums)):
            if left_sum == (total - nums[i]) / 2:
                return i
            left_sum += nums[i]
        return -1

    # 前缀和法
    def pivotIndex2(self, nums: List[int]) -> int:
        left_sum = 0
        S = sum(nums)
        for i in range(len(nums)):
            if S - left_sum - nums[i] == left_sum:
                return i
            left_sum += nums[i]
        return -1

    # 左右双指针，diff数组存储（左边总和-右边总和）
    # 判断diff数据是否有值为0，如果有的话，diff对应的下标就是中心索引
    def pivotIndex3(self, nums: List[int]) -> int:
        left_sum, right_sum = 0, 0
        diff = [0] * len(nums)
        for i, j in zip(range(len(nums)), range(len(nums) - 1, -1, -1)):
            diff[i] += left_sum
            left_sum += nums[i]
            diff[j] -= right_sum
            right_sum += nums[j]
        return diff.index(0) if 0 in diff else -1


nums = [-1, -1, -1, -1, 0, -1]
nums1 = []
nums2 = [1, 1]
s = Solution()
a = s.pivotIndex2(nums)
print(a)
b = s.pivotIndex2(nums1)
print(b)
c = s.pivotIndex2(nums2)
print(c)
