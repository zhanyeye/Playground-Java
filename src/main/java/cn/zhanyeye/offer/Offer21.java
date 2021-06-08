package cn.zhanyeye.offer;


import cn.zhanyeye.common.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class Offer21 {

    /**
     * 首位双指针法：
     * 1. 定义头指针 left, 尾指针 right
     * 2. left 一直向右移，直到它指向的值为偶数
     * 3. right 一直向左移，直到它指向的数值为奇数
     * 4. 交换 nums[left] 和 nums[right]
     * 5. 重复上面的操作，直到 left == right
     */
    public int[] exchange1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 当left == right时，停止
            while (left < right && (nums[left] & 1) == 1) {
                left++;
            }
            // 当left == right时，停止
            while (left < right && (nums[right] & 1) == 0) {
                right--;
            }
            // 当left == right时，停止
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        return nums;
    }

    /**
     * 快慢双指针：
     * 1. 定义快慢指针 fast 和 low
     * 2. fast 的作用是向前搜索奇数的位置，low的作用是指向下一个奇数应当存放的位置
     * 3。 fast 向前移动，当它搜索到奇数时，将它和 nums[low]交换，再将low向前移动一个位置
     * 4. 重复上述操作，直到 fast 指向数组末尾
     */
    public int[] exchange2(int[] nums) {
        // 这里的 fast 指针也必须从0开始，fast 单向遍历，若从1开始，则可能会将0位置的奇数交换到一个不正确的位置
        int low = 0, fast = 0;
        while (fast != nums.length - 1) {
            if ((nums[fast] & 1) == 1) {
                int tmp = nums[fast];
                nums[fast] = nums[low];
                nums[low] = tmp;
                low++;
           }
           fast++;
       }
        return nums;
    }

    public static void main(String[] args) throws IOException {
        // InputStreamReader 将字节流转换成字符流
        // BufferReader      提供了通用的缓冲方式的文本读取，readLine 读取一个文本行
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = Utils.stringToIntegerArray(line);
            int[] ret = new Offer21().exchange2(nums);
            System.out.println(Utils.integerArrayToString(ret));
        }
    }

}

