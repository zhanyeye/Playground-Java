package cn.zhanyeye.offer;

import cn.zhanyeye.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @Author zhanyeye
 * @Description
 * @Date 27/06/2021
 **/
public class Offer06 {
    public int[] reversePrint(ListNode head) {
        ListNode pre = null, cur = head;
        int cnt = 0;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            cnt++;
        }
        int[] ans = new int[cnt];
        ListNode index = pre;
        for (int i =  0; i < cnt; i++) {
            ans[i] = index.val;
            index = index.next;
        }
        return ans;
    }
}
