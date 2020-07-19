public class Leetcode283 {
    public static void main(String[] args) {
        Solution7 s = new Solution7();
        int[] nums = new int[]{1, 3, 0,1,0,3,12, 0, 0};
        s.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

class Solution7 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; ++j) {
            if (nums[j] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                ++i;
            }
        }
    }
}

class Solution6 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                ++i;
            }
            ++j;
        }
        while (i < nums.length) {
            nums[i] = 0;
            ++i;
        }
    }
}

class Solution283 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j;
        while (i < nums.length) {
            while (i < nums.length && nums[i] != 0) {
                ++i;
            }
            j = i + 1;
            while (j < nums.length && nums[j] == 0) {
                ++j;
            }
            if (j < nums.length) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            if ( j >= nums.length)
                break;
        }
    }
}
