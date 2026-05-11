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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        ListNode prev = slow.next = null;

        while (second != null) {
            ListNode curr = second.next;
            second.next = prev;
            prev = second;
            second = curr;
        }

        second = prev;
        ListNode first = head;
        while (first != null && second != null) {
            ListNode headCurr = first.next;
            first.next = second;
            first = headCurr;
            ListNode secondCurr = second.next;
            second.next = headCurr;
            second = secondCurr;
        }

    }
}
