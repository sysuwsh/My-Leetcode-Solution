public class Leetcode209 {
    public static void main(String[] args) {

    }
}

class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int len = nums.length;
        int min_len = len + 1;
        int sum = 0;
        while (end < len) {
            sum += nums[end];
            while (sum >= s) {
                min_len = Math.min(min_len, end - start + 1);
                sum -= nums[start];
                ++start;
            }
            ++end;
        }
        return min_len == len + 1 ? 0 : min_len;
    }
}
