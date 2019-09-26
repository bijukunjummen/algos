package org.bk.algo.general.hanoi;

import org.junit.Test;

public class TowerOfHanoi {

    public void move(int n, String source, String destination, String buffer) {
        if (n <= 0) return;
        move(n - 1, source, buffer, destination);
        moveTop(source, destination);
        move(n - 1, buffer, destination, source);
    }

    private void moveTop(String source, String destination) {
        System.out.println("Moving top from " + source + " to " + destination);
    }

    @Test
    public void testHanoi() {
        move(3, "One", "Three", "Two");
    }

}
