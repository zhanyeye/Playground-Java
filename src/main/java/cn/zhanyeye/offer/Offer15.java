package cn.zhanyeye.offer;

/**
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * @Author zhanyeye
 * @Description
 * @Date 03/07/2021
 **/
public class Offer15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt += n & 1;
            // Java 中无符号右移为 ">>>>>>"
            n >>>= 1;
        }
        return cnt;
    }
}
