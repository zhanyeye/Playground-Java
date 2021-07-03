package cn.zhanyeye.offer;

import cn.zhanyeye.common.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

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

    ArrayList<Integer> tmp = new ArrayList<>();

    public int[] reversePrint1(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }

    public void recur(ListNode head) {
        if (head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }

    public int[] reversePrint3(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();
        }
        return res;
    }

}
