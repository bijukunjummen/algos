package org.bk.algo.dm;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class PriorityQueueTest {

    @Test
    void testMinPq() {
        List<Person> people = List.of(new Person("a", 15), new Person("b", 10), new Person("c", 9));

        PriorityQueue<Person> pq = new PriorityQueue<>(Comparator.comparingInt(Person::age));
        people.forEach(p -> pq.add(p));
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    @Test
    void decTest() {
        ArrayDeque<Person> people = new ArrayDeque<>();
        people.addFirst(new Person("a", 15));
    }

    @Test
    void testDiv() {
        System.out.println((1 >>> 1));
    }

    record Person(String name, int age) {

    }
}
