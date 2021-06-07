package cn.zhanyeye.offer;

import cn.zhanyeye.common.ListNode;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++) {
            // 最好加一个判空检查
            if (former == null) return null;
            former = former.next;
        }
        // 使用 form 判空，而不是 form.next 判空，这样计数正好正确
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}