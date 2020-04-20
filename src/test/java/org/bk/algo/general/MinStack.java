package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class MinStack {

    /**
     * initialize your data structure here.
     */
    private TreeMap<Integer, Integer> map = new TreeMap<>();
    private Deque<Integer> stack = new ArrayDeque<>();

    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (map.containsKey(x)) {
            map.put(x, map.get(x) + 1);
        } else {
            map.put(x, 1);
        }
    }

    public void pop() {
        Integer n = stack.pop();
        if (n != null) {
            if (map.containsKey(n)) {
                Integer currentCount = map.get(n);
                if (currentCount > 1) {
                    map.put(n, currentCount - 1);
                } else {
                    map.remove(n);
                }
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return map.firstKey();
    }


    @Test
    void testMinStack() {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);

        assertThat(minStack.getMin()).isEqualTo(0);
        assertThat(minStack.top()).isEqualTo(0);

        minStack.pop();
        assertThat(minStack.getMin()).isEqualTo(0);
        assertThat(minStack.top()).isEqualTo(1);

        minStack.pop();
        assertThat(minStack.getMin()).isEqualTo(0);
        assertThat(minStack.top()).isEqualTo(0);


    }


}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */