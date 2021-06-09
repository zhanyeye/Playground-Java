package cn.zhanyeye.offer;

/**
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 */
public class Offer63 {
    /**
     * 遍历数组的过程中维护一个最小值
     * 1. 若 prices[i] - min 大于 ans, 则跟新 ans
     * 2. 若当前 prices[i] 比 min 还小，则更新 min
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0], ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return ans;
    }
}
