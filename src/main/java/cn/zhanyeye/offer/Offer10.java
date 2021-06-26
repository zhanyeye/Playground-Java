package cn.zhanyeye.offer;

/**
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
class Offer10 {
    // 简单的动态规划
    public int numWays(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }
    // 简单的斐波那契
    public int numWays2(int n) {
        if (n <= 1) return 1;
        int pre = 1, cur = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = (pre + cur) % 1000000007;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }
}