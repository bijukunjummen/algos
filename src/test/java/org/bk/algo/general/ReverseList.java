package org.bk.algo.general;

import org.junit.Test;

class ListNode {
    String value;
    ListNode next;

    public ListNode(String value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}

class SwapNodes {
    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head.next;

        if (second != null) {
            ListNode tmp = second.next;
            second.next = first;

            first.next = swapPairs(tmp);
            return second;
        } else {
            return first;
        }
    }
}

public class ReverseList {

    @Test
    public void testReverseList() {
        ListNode listNode = new ListNode("1", new ListNode("2", new ListNode("3", null)));
        ListNode result = reverseList(listNode);

        System.out.println(result);
    }
    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    public ListNode reverseList(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverseList(next, head);
    }


}