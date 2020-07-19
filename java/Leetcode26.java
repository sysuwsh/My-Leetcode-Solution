public class Leetcode26 {
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        int[] nums = new int[]{0};
        System.out.println(s.removeDuplicates(nums));
    }
}

class Solution4 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            while (j < nums.length && nums[j] == nums[i]) {
                ++j;
            }
            ++i;
            if (j < nums.length)
                nums[i] = nums[j];
        }
        return i;
    }
}
