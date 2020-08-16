public class Leetcode153 {
    public static void main(String[] args) {
        Solution153 s = new Solution153();
        int[] nums = new int[]{};
        System.out.println(s.findMin(nums));
    }
}

class Solution153 {
    public int findMin(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1])
                return nums[i];
        }
        return nums[0];
    }
}