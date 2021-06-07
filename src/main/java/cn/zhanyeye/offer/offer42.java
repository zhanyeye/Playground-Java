package cn.zhanyeye.offer;

/**
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
class Offer42 {
    // dp[i]: 表示长度为i的数组的连续子数组的最大和
    // dp[i] = dp[i-1] + nums[i]   dp[i-1] > 0
    // dp[i] = nums[i]             dp[i-1] <= 0
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i-1] > 0 ? dp[i-1] + nums[i] : nums[i];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}