package cn.zhanyeye.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 */
public class Offer20 {
    /**
     * 算法流程：
     * 有限状态自动机
     * 字符类型：空格[ ]、数字[0-9]、正负号[+-]、小数点[.]、幂符号[Ee]
     * 状态定义（按照字符从左到右的顺序，定义以下9钟状态）：
     * 0. 起始的空格
     * 1. 符号位
     * 2. 整数部分
     * 3. 左侧有整数的小数点
     * 4. 左侧无整数的小数点（根据前面的第二条额外规则，需要对左侧有无整数的两种小数点做区分）
     * 5. 小数部分
     * 6. 字符e
     * 7. 指数部分的符号位
     * 8. 指数部分的整数部分
     * 9. 末尾空格
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        // 状态的集合
        Map[] states = {
                new HashMap<>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0 起始的空格
                new HashMap<>() {{ put('d', 2); put('.', 4); }},                           // 1 符号位
                new HashMap<>() {{ put('d', 2); put('.', 3); put('e', 6); put(' ', 9); }}, // 2 整数部分
                new HashMap<>() {{ put('d', 5); put('e', 6); put(' ', 9); }},              // 3 左侧有整数的小数点
                new HashMap<>() {{ put('d', 5);  }},                                       // 4 左侧无整数的小数点
                new HashMap<>() {{ put('d', 5); put('e', 6); put(' ', 9); }},              // 5 小数部分
                new HashMap<>() {{ put('s', 7); put('d', 8); }},                           // 6 字符e
                new HashMap<>() {{ put('d', 8); }},                                        // 7 指数部分的符号位
                new HashMap<>() {{ put('d', 8);  put(' ', 9); }},                          // 8 指数部分的整数部分
                new HashMap<>() {{ put(' ', 9); }},                                        // 9 末尾空格
        };
        int p = 0;
        char t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') t = 'd';
            else if (c == '+' || c == '-') t = 's';
            else if (c == 'e' || c == 'E') t = 'e';
            else if (c == '.' || c == ' ') t = c;
            else t = '?';
            if (!states[p].containsKey(t)) {
                return false;
            }
            p = (int) states[p].get(t);
        }
        return p == 2 || p == 3 || p == 5 || p == 8 || p == 9;
    }

    public static void main(String[] args) {
        boolean out = new Offer20().isNumber(". ");
        System.out.println(out);
    }
}
