package cn.zhanyeye.offer;

import java.util.HashMap;
import java.util.Map;

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

    // 自底向上
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 2; j <= i/2 + 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i-j), j * dp[i-j]));
            }
        }
        return dp[n];
    }


    /**
     * 切分规则
     * 最优： 3 。把绳子尽可能切为多个长度为 3 的片段，留下的最后一段绳子的长度可能为 0,1,2 三种情况。
     * 次优： 2 。若最后一段绳子长度为 2 ；则保留，不再拆为 1+1 。
     * 最差： 1 。若最后一段绳子长度为 1 ；则应把一份 3 + 1 替换为 2 + 2，因为 2 × 2 > 3 × 1。
     */
    public int cuttingRope2(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0) {
            return (int)Math.pow(3, a);
        } else if (b == 1) {
            return (int)Math.pow(3, a - 1) * 4;
        } else {
            return (int)Math.pow(3, a) * 2;
        }
    }

    // 动态规划--记忆递归--自顶向下
    int[] memory = new int[59];
    public int recur(int n) {
        if (n == 1 || n == 2) return 1;
        int ans = 0;
        for (int i = 1; i <= n/2; i++) {
            ans = Math.max(ans, Math.max(i * (n-i), i * (memory[n-i] != 0 ? memory[n-i] : recur(n-i))));
        }
        memory[n] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Offer14i offer14i = new Offer14i();
        System.out.println(offer14i.cuttingRope(43));
        System.out.println(offer14i.recur(43));
    }
}
