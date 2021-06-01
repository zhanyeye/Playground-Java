/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++) {
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