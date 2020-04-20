package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class PermsAndCombs {

    public List<List<String>> getPerms(List<String> list, int k) {
        List<List<String>> res = new ArrayList<>();
        permsHelper(List.of(), list, k, res);
        return res;
    }

    private void permsHelper(List<String> pre, List<String> post, int k, List<List<String>> res) {
        if (pre.size() == k) {
            res.add(pre);
        }
        if (post.size() == 0) {
            return;
        }

        for (String s : post) {
            List<String> newPre = new ArrayList<>(pre);
            newPre.add(s);

            List<String> newPost = new ArrayList<>();
            for (String r : post) {
                if (!r.equals(s)) {
                    newPost.add(r);
                }
            }
            permsHelper(newPre, newPost, k, res);
        }
    }

    public List<List<String>> getCombinations(List<String> list, int k) {
        List<List<String>> result = new ArrayList<>();
        getCombsHelper(List.of(), list, result, k);
        return result;
    }

    private void getCombsHelper(List<String> pre, List<String> post, List<List<String>> result, int k) {
        if (k == 0) {
            result.add(pre);
            return;
        }

        if (post.size() == 0) {
            return;
        }

        String head = getHead(post);
        List<String> tail = getTail(post);

        // Without head
        getCombsHelper(pre, tail, result, k);


        getCombsHelper(addElement(pre, head), tail, result, k - 1);
    }


    private static List<String> addElement(List<String> list, String elem) {
        List<String> copy = new ArrayList<>(list);
        copy.add(elem);
        return copy;
    }

    private static List<String> removeElement(List<String> list, String elem) {
        List<String> copy = new ArrayList<>(list);
        copy.remove(elem);
        return copy;
    }

    private static String getHead(List<String> list) {
        if (list == null || list.size() == 0) return null;
        return list.get(0);
    }

    private static List<String> getTail(List<String> list) {
        if (list == null || list.size() == 0) return List.of();
        List<String> tail = new ArrayList<>(list.subList(1, list.size()));
        return tail;
    }

    public Set<Set<String>> getCombs(Set<String> set, int k) {
        Set<Set<String>> res = new HashSet<>();
        combsHelper(Set.of(), set, k, res);
        return res;
    }

    private void combsHelper(Set<String> pre, Set<String> post, int k, Set<Set<String>> res) {
        if (pre.size() == k) {
            res.add(pre);
        }
        if (post.size() == 0) {
            return;
        }
        for (String s : post) {
            Set<String> newPre = new HashSet<>(pre);
            newPre.add(s);

            Set<String> newPost = new HashSet<>();
            for (String r : post) {
                if (!r.equals(s)) {
                    newPost.add(r);
                }
            }
            combsHelper(newPre, newPost, k, res);
        }

    }


    @Test
    void testGetPermutations() {
        List<List<String>> c = getPerms(List.of("a", "b", "c"), 2);
        System.out.println(c);
        assertThat(c.size()).isEqualTo(6);

        assertThat(new HashSet<>(c))
                .isEqualTo(Set.of(
                        List.of("a", "b"), List.of("a", "c"),
                        List.of("b", "a"), List.of("b", "c"),
                        List.of("c", "a"), List.of("c", "b")
                ));

        System.out.println(getPerms(List.of("a", "b", "c", "d", "e"), 3));
        System.out.println(getPerms(List.of("a", "b", "c", "d", "e"), 3).size());
    }

    @Test
    void testGetCombs() {
        Set<Set<String>> c = getCombs(Set.of("a", "b", "c", "d", "e"), 2);
        System.out.println(c);

        assertThat(c.size()).isEqualTo(10);
        //
        // assertThat(new HashSet<>(c))
        //         .isEqualTo(Set.of(
        //                 List.of("a", "b"), List.of("a", "c"),
        //                 List.of("b", "a"), List.of("b", "c"),
        //                 List.of("c", "a"), List.of("c", "b")
        //         ));

    }

    @Test
    void testGetCombinations() {
        List<List<String>> c = getCombinations(List.of("a", "b", "c", "d", "e", "f", "g", "h"), 5);
        assertThat(c.size()).isEqualTo(56);

    }

}
