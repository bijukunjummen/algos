package org.bk.algo.general.hanoi;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class TowerOfHanoi {
    public void solve(int n) {
        Deque<Integer> sourceRings = new ArrayDeque<>();
        for (int i = n; i >= 1; i--) {
            sourceRings.push(i);
        }
        Tower towerA = new Tower("A", sourceRings);
        Tower towerB = new Tower("B", new ArrayDeque<>());
        Tower towerC = new Tower("C", new ArrayDeque<>());
        move(towerA, towerC, towerB, n);
    }

    private void move(Tower begin, Tower end, Tower temp, int n) {
        if (n == 1) {
            Integer value = begin.rings.pop();
            System.out.println("Move " + value + " from " + begin.id + " to " + end.id);
            end.rings.push(value);
        } else {
            move(begin, temp, end, n - 1);
            move(begin, end, temp, 1);
            move(temp, end, begin, n - 1);
        }
    }

    static class Tower {
        private String id;
        private Deque<Integer> rings;

        Tower(String id, Deque<Integer> rings) {
            this.id = id;
            this.rings = rings;
        }
    }

    @Test
    public void testHanoi() {
        solve(3);
    }
}
