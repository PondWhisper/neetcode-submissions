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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists[0] == null) {
            return null;
        }

        ListNode init = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ListNode curr = lists[i];
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            while (init != null && curr != null) {
                if (init.val < curr.val) {
                    tail.next = init;
                    init = init.next;
                } else {
                    tail.next = curr;
                    curr = curr.next;
                }
                tail = tail.next;
            }
            tail.next = (init == null) ? curr : init;

            init = dummy.next;
        }
        return init;
    }
}
