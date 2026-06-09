/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = head;
        ListNode last = dummy;

        for (int i = 0; i < n; i++) {
            if (prev != null) prev = prev.next;
        }

        while (prev != null) {
            prev = prev.next;
            last = last.next;
        }

        last.next = last.next.next;
        return dummy.next;
    }
}
