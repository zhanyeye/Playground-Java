package cn.zhanyeye.offer;

/**
 * @Author zhanyeye
 * @Description
 * @Date 28/06/2021
 **/
public class Offer14ii {

    /**
     * 切分规则
     * 最优： 3 。把绳子尽可能切为多个长度为 3 的片段，留下的最后一段绳子的长度可能为 0,1,2 三种情况。
     * 次优： 2 。若最后一段绳子长度为 2 ；则保留，不再拆为 1+1 。
     * 最差： 1 。若最后一段绳子长度为 1 ；则应把一份 3 + 1 替换为 2 + 2，因为 2 × 2 > 3 × 1。
     */
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if (b == 0) return (int) (rem * 3 % p);
        if (b == 1) return (int) (rem * 4 % p);
        return (int) (rem * 6 % p);
    }


    /**
     * 介绍求余运算性质
     * (a + b) % p = (a % p + b % p) % p （1）
     * (a - b) % p = (a % p - b % p) % p （2）
     * (a * b) % p = (a % p * b % p) % p （3）
     *  a ^ b % p = ((a % p)^b) % p       （4）
     */

    //////////////////////////////
    // 大数求余解法
    // 大数越界： 当 a 增大时，最后返回的 3^a大小以指数级别增长，可能超出 int32 甚至 int64 的取值范围，导致返回值错误。
    // 大数求余问题： 在仅使用 int32 类型存储的前提下，正确计算 x^a 对 p 求余（即 x^a % p ）的值。
    // 解决方案： 循环求余 、 快速幂求余 ，其中后者的时间复杂度更低，两种方法均基于以下求余运算规则推出： (xy) % p=[(x % p)(y % p)] % p
    /////////////////////////////

    /**
     * 1. 循环求余
     * ∵ 本题中 x < p，∴ x % p = x
     * 推出：x^a % p=[(x^(a−1) % p)(x % p)] % p= [(x ^(a−1)% p) x ] % p
     * 解析： 利用此公式，可通过循环操作依次求 x^1, x^2, ..., x^{a-1}, x^a  对 p 的余数，保证每轮中间值 rem 都在 int32 取值范围中。封装方法代码如下所示。
     * x^3 % p => ((x^2 % p) * x) % p => ((((x^1 % p) * x) % p) * x) % p
     * 所以倒过来循环求余即可！
     */
    public int remainder1(int x, int a, int p) {
        int rem = 1;
        for (int i = 0; i < a; i++) {
            rem = (rem * x) % p;
        }
        return rem;
    }

    /**
     * 2. 快速幂求余
     * 根据求余运算性质可推出：x^a % p=(x^2)^(a/2) % p=(x^2 % p)^(a/2) % p
     * 当 a 为奇数时 a/2 不是整数，因此分为以下两种情况（ '//' 代表向下取整的除法）
     * 当 a 为偶数时：x^a % p = (x^2)^(a//2) % p = (x^2 % p)^(a//2) % p
     * 当 a 为奇数时：x^a % p = xx^(a-1) % p = [(x % p)(x^(a-1) % p)] % p = [x(x^2 % p)^(a//2)] % p
     */
    public int remainder2(int x, int a, int p) {
        int rem = 1;
        while (a > 0) {
            if (a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
            a /= 2;
        }
        return rem;
    }

    public int remainder3(int x, int a, int p) {
        int rem = 1;
        for (; a > 0; a /= 2) {
            if (a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        return rem;
    }

}
