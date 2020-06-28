package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class WordLadderTest {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordListSet = Set.copyOf(wordList);
        Set<Character> possibleLetters = endWord.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        Deque<String> queue = new LinkedList<>();

        queue.add(beginWord);

        while (!queue.isEmpty()) {
            String nextWord = queue.poll();
            System.out.println("Considering " + nextWord);
            if (nextWord.equals(endWord)) {
                System.out.println("Found " + nextWord);
            }
            queue.addAll(nextWords(nextWord, possibleLetters, wordListSet));
        }

        return -1;

    }

    private List<String> nextWords(String word, Set<Character> possibleLetters, Set<String> wordList) {
        List<String> nextWords = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (Character p : possibleLetters) {
                if (c != p.charValue()) {
                    final String s = word.substring(0, i) + p + word.substring(i + 1);
                    if (wordList.contains(s)) {
                        nextWords.add(s);
                    }
                }
            }
        }
        return nextWords;
    }

    @Test
    void testFindLength() {
        ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"));
    }
    @Test
    void testNextWords() {
        System.out.println(nextWords("hit", Set.of('c', 'o', 'g'), Set.of("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(nextWords("hot", Set.of('c', 'o', 'g'), Set.of("hot", "dot", "dog", "lot", "log", "cog")));
    }


    @Test
    public void testFindLadder() {
        // assertThat(findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")))
        //         .isEqualTo(List.of(
        //                 List.of("hit", "hot", "dot", "dog", "cog"),
        //                 List.of("hit", "hot", "lot", "log", "cog")));
        //
        // assertThat(findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log")))
        //         .isEmpty();
        //
        // assertThat(findLadders("a", "c", List.of("a", "b", "c")))
        //         .isEqualTo(List.of(List.of("a", "c")));

    }
}