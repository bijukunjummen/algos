package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

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
class ReOrderList {
    public void reorderList(ListNode head) {
        ListNode node = head;
        while (node.next != null) {
            ListNode tmp = node.next;
            ListNode last = getLastAndDisconnect(node);

            node.next = last;

            last.next = tmp;
            node = tmp;
        }
    }

    ListNode getLastAndDisconnect(ListNode head) {
        ListNode node = head;
        ListNode prev = null;
        while (node.next != null) {
            prev = node;
            node = node.next;
        }
        prev.next = null;
        return node;
    }


    static class ListNode {
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

        @Override
        public String toString() {
            return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
                    .add("val=" + val)
                    .toString();
        }
    }


    @Test
    void testReorder() {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList(listNode);
    }
}