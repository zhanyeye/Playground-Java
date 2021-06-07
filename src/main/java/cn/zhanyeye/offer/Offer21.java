package cn.zhanyeye.offer;

import cn.zhanyeye.common.Solution;

/**
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
class Offer21 extends Solution {

    @Override
    public void run() {
        int[] nums = {1, 2, 3, 4};
        exchange1(nums);
    }

    /**
     * 
     */
    public int[] exchange1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while ((nums[left] & 1) == 1) left++;
            while ((nums[right] & 1) == 0) right--;
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }

//    public int[] exchange2(int[] nums) {
//
//    }
}