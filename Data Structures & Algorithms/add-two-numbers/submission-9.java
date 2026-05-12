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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;

        //这里要着重看别人是怎么解决这个问题的,当merge两个linkedlist但是两个list长度不一样
        int addNum = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            ListNode time = new ListNode((l1.val + l2.val + addNum) % 10);
            addNum = (l1.val + l2.val + addNum) / 10;
            l1 = l1.next;
            l2 = l2.next;
            curr.next = time;
            curr = curr.next;
        }

        curr.next = addNum > 0 ? new ListNode(addNum) : null;

        return res.next;

    }
}
