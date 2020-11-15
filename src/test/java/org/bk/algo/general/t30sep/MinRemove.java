package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MinRemove {
    public String minRemoveToMakeValid(String s) {
        char[] sArr = s.toCharArray();
        List<OpAndIndex> removeList = new ArrayList<>();
        Deque<OpAndIndex> stack = new ArrayDeque<>();

        for (int i = 0; i < sArr.length; i++) {
            char c = sArr[i];
            if (c == '(') {
                stack.push(new OpAndIndex('(', i));
            } else if (c == ')') {
                OpAndIndex top = stack.peek();
                if (top != null && top.op == '(') {
                    stack.pop();
                } else {
                    removeList.add(new OpAndIndex(')', i));
                }
            }
        }
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                removeList.add(stack.pop());
            }
        }

        int remSize = removeList.size();
        for (int i = remSize - 1; i >= 0; i--) {
            OpAndIndex toRemove = removeList.get(i);
            sArr[toRemove.index] = '0';
        }
        char[] target = new char[sArr.length - remSize];


        for (int i = 0, ti = 0; i < sArr.length; i++) {
            if (sArr[i] != '0') {
                target[ti++] = sArr[i];
            }
        }

        return new String(target);
    }

    static class OpAndIndex {
        char op;
        int index;

        OpAndIndex(char op, int index) {
            this.op = op;
            this.index = index;
        }
    }

    @Test
    void testRemoval() {
        assertThat(minRemoveToMakeValid("lee(t(c)o)de)")).isEqualTo("lee(t(c)o)de");
    }
}