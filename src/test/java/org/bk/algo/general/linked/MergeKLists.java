package org.bk.algo.general.linked;

class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode current = head;
        ListNode listNode = findMin(lists);
        while (listNode != null) {
            current.next = listNode;
            listNode = findMin(lists);
            current = current.next;
        }
        return head.next;
    }

    private ListNode findMin(ListNode[] lists) {
        ListNode min = null;
        int minIndex = -1;

        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node != null) {
                if (min == null || node.val < min.val) {
                    min = node;
                    minIndex = i;
                }
            }
        }
        if (minIndex != -1) {
            lists[minIndex] = lists[minIndex].next;
        }
        return min;
    }
}