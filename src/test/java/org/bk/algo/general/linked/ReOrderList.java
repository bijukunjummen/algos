package org.bk.algo.general.linked;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReOrderList {
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode lastHead = last(head, mid);
        lastHead.next = null;
        ListNode tail = reverse(mid);

        merge(head, tail);
    }

    private ListNode last(ListNode node, ListNode nextTarget) {
        while (node.next != nextTarget) {
            node = node.next;
        }
        return node;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;
            l1.next = l2;
            l2.next = temp1;
            l1 = temp1;
            l2 = temp2;
        }
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            fast = (fast != null) ? fast.next : null;
        }
        return slow;
    }

    private ListNode reverse(ListNode mid) {
        ListNode curr = mid;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    @Test
    void testReOrder() {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList(listNode);
        assertThat(listNode)
                .isEqualTo(new ListNode(1, new ListNode(4, new ListNode(2, new ListNode(3)))));
    }

}