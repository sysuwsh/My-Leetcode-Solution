import java.util.HashMap;
import java.util.Map;

public class Leetcode494 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0,0,0,0,0,1};
        int target = 1;
        Solution494 s = new Solution494();
        System.out.println(s.findTargetSumWays(nums, target));
    }
}

// 采用动态规划的思想
// 假设我们的任务是，对于集合nums，找出A个数字是取+的，B个数字是取-的，那么最后的target = sum(A) - sum(B)
// sum(A) = target + sum(B)  ->  2 * sum(A) = target + sum(B) + sum(A) -> 2 * sum(A) = target + sum(nums)
// 所以任务就转换成了存在多少个子集A，使得sum(A) = (target + sum(nums)) / 2
// 这就是一个典型的0-1背包问题，现在又nums.length个物品，每个物品的重量为nums[i]，任意取物品使得重量为target，问有多少种取法
// 我们可以设一个二维dp数组，dp[i][j]的意思就是，当只在前i个物品中进行选择，当前背包可承受重量为j时的选法有多少种，而最终要的结果就是dp[nums.length][sum(A)]
/* 那么状态转移方程就是：
    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]]  当 j >= nums[i - 1]  要么前i-1个物品选择就可以装满j了，要么前i-1个物品装了j - nums[i - 1]，然后剩下的nums[i - 1]的重量就由物品i来填
    dp[i][j] = dp[i - 1][j]  当 j < nums[i - 1]  就是当第i个物品重量已经大于了背包的最大承重，所以只能采用前i-1个物品的选择方法
    特殊的：
    dp[0][...] = 0  就是没有任何物品，那么任何背包承重都无法满足
    (dp[...][0] = 1  当背包承重为0时，不选任何物品放入就是唯一的方法) 这句话应该不对，因为当背包承重为0的时候，可能有x个物品的重量都为0，那么在这x个物品中任意选就好了
*/
class Solution494 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n: nums) sum += n;
        if (sum < S || (S + sum) % 2 == 1) {
            return 0;
        }
        return numOfSubset(nums, (sum + S) / 2);
    }

    public int numOfSubset(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; ++i)
            dp[i][0] = 1;
        for (int i = 1; i <= n; ++i) {
            // 注意这里j必须从0开始，详情见第24行
            for (int j = 0; j <= sum; ++j) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}

// 采用动态规划的思想时，可以优化一下dp数组的空间
// 由状态方程可知，dp[i][j]只和i-1时候的值有关，因此可以将dp[n][sum]的空间优化为dp[sum]的空间
class Solution494_1 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n: nums) sum += n;
        if (sum < S || (S + sum) % 2 == 1) {
            return 0;
        }
        return numOfSubset(nums, (sum + S) / 2);
    }

    public int numOfSubset(int[] nums, int sum) {
        int n = nums.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = sum; j >= 0; --j) {
                if (j >= nums[i - 1]) {
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[sum];
    }
}


// 采用回溯法的时候，有可能出现重复的状态，就是当i和target都相等的时候
// 这个时候可以采用一个备忘录来记录下出现过的状态，遇到的时候直接调用结果就好
class Solution494_2 {
    private Map<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int S) {
        return dfsMemo(nums, 0, S);
    }

    public int dfsMemo(int[] nums, int i, int target) {
        if (i == nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        String key = i + "," + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int result = dfsMemo(nums, i + 1, target - nums[i]) + dfsMemo(nums, i + 1, target + nums[i]);
        memo.put(key, result);
        return result;
    }
}


// 采用dfs回溯的方式进行穷举
class Solution494_3 {
    private int res = 0;

    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, S);
        return this.res;
    }

    public void dfs(int[] nums, int i, int target) {
        if (i == nums.length) {
            if (target == 0)
                ++this.res;
            return;
        }
        dfs(nums, i + 1, target - nums[i]);
        dfs(nums, i + 1, target + nums[i]);
    }
}