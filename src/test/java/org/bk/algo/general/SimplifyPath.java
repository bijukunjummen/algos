package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

class SimplifyPath {
    public String simplifyPath(String path) {
        String[] splits = path.split("/+");
        List<String> listWithoutSameDir = Arrays.stream(splits).filter(s -> !s.equals(".")).toList();
        Deque<String> stack = new ArrayDeque<>();
        for (String s : listWithoutSameDir) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            if (!(s.equals(".") || s.equals(""))) {
                stack.push(s);
            }
        }
        Iterable<String> iterable = () -> stack.descendingIterator();
        String collect = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.joining("/"));
        return "/" + collect;
    }

    @Test
    void testSimplifyPath() {
        assertThat(simplifyPath("/home//foo/")).isEqualTo("/home/foo");
        assertThat(simplifyPath("/home/")).isEqualTo("/home");
        assertThat(simplifyPath("/home/user/Documents/../Pictures")).isEqualTo("/home/user/Pictures");
        assertThat(simplifyPath("/../")).isEqualTo("/");
    }

}