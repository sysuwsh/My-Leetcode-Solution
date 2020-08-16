import java.util.Arrays;

public class Leetcode561 {
    public static void main(String[] args) {
        Solution561 s = new Solution561();
        int[] num = new int[]{6214, -2290, 2833, -7908};
        int sum = s.arrayPairSum(num);
        System.out.println(sum);
    }
}

class Solution561 {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}

// 采用hash的方式，时间复杂度为O(n)
class Solution561_1 {
    public int arrayPairSum(int[] nums){
        int[] count = new int[20005];
        int sum = 0;
        int reminder = 0;  //reminder表示当前count列需要向下一个列借0个或者1个元素
        for (int num : nums) {
            count[num + 10000]++;
        }
        for (int i = 0; i < 20001; ++i) {
            if (count[i] != 0) {
                sum += (count[i] + 1 - reminder) / 2 * (i - 10000);
                reminder = (count[i] - reminder) % 2;
            }
        }
        return sum;
    }
}