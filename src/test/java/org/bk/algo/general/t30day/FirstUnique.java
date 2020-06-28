package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class FirstUnique {
    private Set<Integer> uniqueQueue = new LinkedHashSet<>();
    private Set<Integer> alreadyPresent = new HashSet<>();

    public FirstUnique(int[] nums) {
        for (int n : nums) {
            add(n);
        }
    }

    public int showFirstUnique() {
        final Iterator<Integer> iterator = uniqueQueue.iterator();
        Integer first = iterator.hasNext() ? iterator.next() : null;
        if (first == null) {
            return -1;
        }
        return first.intValue();
    }

    public void add(int value) {
        if (alreadyPresent.contains(value)) {
            if (uniqueQueue.contains(value)) {
                uniqueQueue.remove(value);
            }
        } else {
            alreadyPresent.add(value);
            uniqueQueue.add(value);
        }
    }
}

class UniqTest {

    @Test
    void testUniqueue() {
        FirstUnique firstUnique = new FirstUnique(new int[]{2, 3, 5});
        assertThat(firstUnique.showFirstUnique()).isEqualTo(2);
        firstUnique.add(5);
        assertThat(firstUnique.showFirstUnique()).isEqualTo(2);
        firstUnique.add(2);
        assertThat(firstUnique.showFirstUnique()).isEqualTo(3);
        firstUnique.add(3);
        assertThat(firstUnique.showFirstUnique()).isEqualTo(-1);

    }
}