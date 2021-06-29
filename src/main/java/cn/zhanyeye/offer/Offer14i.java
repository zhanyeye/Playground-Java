package cn.zhanyeye.offer;

/**
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * @Author zhanyeye
 * @Description
 * @Date 28/06/2021
 **/
public class Offer14i {

    // 1. 用 dp[i] 来表示长度为 i 的绳子减成 m 段后的最大乘积; 初始化 dp[2] = 1
    // 2. 我们设每次减掉的长度为 j, 若 j为1，对乘积无任何增益，所以 j从2开始减
    // 3. 减掉长度为 j 后，还剩下 i - j 的长度，此时 乘积可以是 j * (i-j); 剩余的(i-j)还可以继续减下去，即求减(i-j)的max => dp[i-j]
    //    两者取最大值为：max(j * (i - j), j * dp[i-j])
    // 4. 第一次减掉的长度j 取值为[2, i), 对所有j的不同情况取最大值，最终dp[i]的状态转移方程为
    //     dp[i] = max(dp[i], max(j * (i-j), j * dp[i-j])); j=>[2,i)
    // 5. 最后返回 dp[n] 即可
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i-j), j * dp[i-j]));
            }
        }
        return dp[n];
    }
}
