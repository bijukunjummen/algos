package org.bk.algo.core.linkedlist;

public class NthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        for (int i = 0; i < n; i++) {
            current = current.next;
        }
        if (current == null) {
            return head.next;
        }
        ListNode nodeBefore = head;

        while (current.next != null) {
            current = current.next;
            nodeBefore = nodeBefore.next;
        }
        nodeBefore.next = nodeBefore.next.next;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
