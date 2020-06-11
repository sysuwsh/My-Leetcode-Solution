public class Leetcode724 {
    public static void main(String[] args) {
        int[] nums = {-1, -1, -1, -1, 0, -1};
        Solution s = new Solution();
        int result = s.pivotIndex(nums);
        System.out.println(result);

        Solution1 s1 = new Solution1();
        int result1 = s1.pivotIndex(nums);
        System.out.println(result1);

    }
}

// 前缀和解法
class Solution{
    public int pivotIndex(int[] nums) {
        int left_sum = 0;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        for (int i = 0; i < nums.length; ++i) {
            if(total - left_sum - nums[i] == left_sum){
               return i;
            }
            left_sum += nums[i];
        }
        return -1;
    }
}

// 双指针解法
class Solution1{
    public int pivotIndex(int[] nums){
        int left = 0;
        int right = 0;
        int[] diff = new int[nums.length];
        for(int i = 0, j = nums.length - 1; i < nums.length; ++i, --j){
            diff[i] += left;
            left += nums[i];
            diff[j] -= right;
            right += nums[j];
        }
        for(int i = 0; i < nums.length; ++i){
            if(diff[i] == 0){
                return i;
            }
        }
        return -1;
    }
}
