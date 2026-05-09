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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode reverseList = new ListNode(head.val);

        while (head.next != null) {
            head = head.next;
            ListNode curr = new ListNode(head.val);
            curr.next = reverseList;
            reverseList = curr;
        }

        return reverseList;

    }
}
