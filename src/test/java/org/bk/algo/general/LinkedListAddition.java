package org.bk.algo.general;

import org.junit.jupiter.api.Test;

public class LinkedListAddition {
}


class ListNodeSum {
    int val;
    ListNodeSum next;

    ListNodeSum(int x, ListNodeSum next) {
        val = x;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNodeSum{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class Solution {

    @Test
    public void testSum() {
        System.out.println(addTwoNumbers(
                new ListNodeSum(2, new ListNodeSum(4, new ListNodeSum(9, null))),
                new ListNodeSum(5, new ListNodeSum(6, new ListNodeSum(4, null)))
        ));
    }

    public static ListNodeSum addTwoNumbers(ListNodeSum l1, ListNodeSum l2) {
        ListNodeSum head = null;
        ListNodeSum curr = null;
        int carryOver = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carryOver;
            carryOver = sum / 10;
            if (curr == null) {
                curr = new ListNodeSum(sum % 10, null);
                if (head == null) {
                    head = curr;
                }
            } else {
                ListNodeSum tmp = new ListNodeSum(sum % 10, null);
                curr.next = tmp;
                curr = tmp;
            }
            if (l1 != null)
                l1 = l1.next;

            if (l2 != null)
                l2 = l2.next;
        }

        if (carryOver > 0) {
            ListNodeSum tmp = new ListNodeSum(carryOver, null);
            curr.next = tmp;
        }

        return head;
    }
}
