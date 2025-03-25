package org.bk.algo.core.linkedlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LinkedListAlgoTest {

    @Test
    public void testIterativeAddition() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.insertAtHead(5);
        list.insertAtHead(6);
        list.insertAtHead(9);

        LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
        linkedList2.insertAtHead(4);
        linkedList2.insertAtHead(5);
        linkedList2.insertAtHead(3);

        assertThat(sumIter(list, linkedList2).toString()).isEqualTo("2-2-0-1-");
    }

    Node<Integer> reverse(Node<Integer> l) {
        Node<Integer> current = l;
        Node<Integer> prev = null;

        while (current != null) {
            Node<Integer> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    Node<Integer> reverseRecursive(Node<Integer> l) {
        return reverseRecursiveHelper(l);
    }

    Node<Integer> reverseRecursiveHelper(Node<Integer> l) {
        if (l.next == null) {
            return l;
        }
        Node<Integer> curr = reverseRecursiveHelper(l.next);
        l.next.next = l;
        l.next = null;
        return curr;
    }
    @Test
    void testReverse() {
        Node<Integer> l = new Node<>(1, new Node<>(2, new Node<>(3, null)));
        Node<Integer> reversed = reverse(l);
        assertThat(reversed.data).isEqualTo(3);
    }

    @Test
    void testReverseRecursive() {
        Node<Integer> l = new Node<>(1, new Node<>(2, new Node<>(3, null)));
        Node<Integer> reversed = reverseRecursive(l);
        assertThat(reversed.data).isEqualTo(3);
    }

    @Test
    public void testRecursiveAddition() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.insertAtHead(5);
        list.insertAtHead(6);
        list.insertAtHead(9);

        LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
        linkedList2.insertAtHead(4);
        linkedList2.insertAtHead(5);
        linkedList2.insertAtHead(3);

        assertThat(sumRecursive(list, linkedList2).toString()).isEqualTo("2-2-0-1-");
    }

    @Test
    public void testForStartOfALoop() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.insertAtHead(7);
        Node<Integer> node6 = list.insertAtHead(6);
        list.insertAtHead(5);
        list.insertAtHead(4);
        Node<Integer> node3 = list.insertAtHead(3);
        list.insertAtHead(2);
        list.insertAtHead(1);
        list.insertAtHead(0);
        node6.next = node3;

        Node<Integer> slow = list.head;
        Node<Integer> fast = list.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return;
        }

        slow = list.head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        System.out.println(fast.data);

    }

    private LinkedList<Integer> sumIter(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        Node<Integer> n1 = l1.head;
        Node<Integer> n2 = l2.head;
        LinkedList<Integer> result = new LinkedList<Integer>();
        Node<Integer> r = null;
        int carry = 0;
        while (n1 != null || n2 != null || carry != 0) {
            int d1 = 0;
            if (n1 != null) {
                d1 = n1.data;
                n1 = n1.next;
            }
            int d2 = 0;
            if (n2 != null) {
                d2 = n2.data;
                n2 = n2.next;
            }

            int val = d1 + d2 + carry;

            int nodeval = val % 10;
            if (r == null) {
                r = new Node<>(nodeval, null);
                result.head = r;
            } else {
                r.next = new Node<>(nodeval, null);
                r = r.next;
            }

            carry = val / 10;
        }

        return result;
    }

    private LinkedList<Integer> sumRecursive(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        Node<Integer> head = sumRecursive(l1.head, l2.head, 0);
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.head = head;
        return ll;
    }

    private Node<Integer> sumRecursive(Node<Integer> n1, Node<Integer> n2, int carry) {
        if (n1 == null && n2 == null && carry == 0) return null;

        int d1 = 0;
        if (n1 != null) {
            d1 = n1.data;
        }

        int d2 = 0;
        if (n2 != null) {
            d2 = n2.data;
        }

        int val = d1 + d2 + carry;

        int nodeval = val % 10;
        Node<Integer> prevNode = sumRecursive(n1 != null ? n1.next : null, n2 != null ? n2.next : null, val / 10);
        Node<Integer> currNode = new Node<Integer>(nodeval, prevNode);

        return currNode;
    }
}

class LinkedList<T> {
    Node<T> head;

    public Node<T> insertAtHead(T item) {
        if (this.head == null) {
            this.head = new Node<T>(item, null);
            return this.head;
        }
        this.head = new Node<T>(item, head);

        return this.head;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        Node<T> node = head;
        while (node != null) {
            buffer.append(node.data + "-");
            node = node.next;
        }
        return buffer.toString();
    }
}

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}