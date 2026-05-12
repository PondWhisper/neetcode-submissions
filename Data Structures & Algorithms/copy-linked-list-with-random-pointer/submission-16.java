/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;

        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        curr = head;
        Node newHead = head == null ? null : head.next;
        while (curr != null) {
            Node time = curr.next;
            if (curr.random != null) {
                time.random = curr.random.next;
            }
            curr = time.next;
        }

        curr = head;
        while (curr != null) {
            Node time = curr.next;
            curr.next = time.next;
            if (time.next != null) {
                time.next = curr.next.next;
            }
            curr = curr.next;
        }

        return newHead;
    }
}
