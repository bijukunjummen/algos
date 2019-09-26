package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class WordLadderTest {
    class Path {
        private final List<String> history;

        private final String currentWord;

        public Path(List<String> history, String currentWord) {
            this.history = Collections.unmodifiableList(history);
            this.currentWord = currentWord;
        }

        public Path extend(String word) {
            List<String> newList = new ArrayList<>(this.history);
            newList.add(word);
            return new Path(Collections.unmodifiableList(newList), word);
        }

        public List<String> getHistory() {
            return this.history;
        }

        public String getCurrentWord() {
            return this.currentWord;
        }

        @Override
        public String toString() {
            return "Path{" +
                    "history=" + history +
                    ", currentWord='" + currentWord + '\'' +
                    '}';
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Path startPath = new Path(List.of(beginWord), beginWord);

        Queue<Path> queue = new ArrayDeque<>();
        queue.add(startPath);

        Set<String> coveredWords = new HashSet<>();

        List<Path> targets = new ArrayList<>();

        while (!queue.isEmpty()) {
            Path path = queue.poll();
            coveredWords.add(path.getCurrentWord());

            List<Path> children = nextSetOfChildren(path, wordList, coveredWords);

            for (Path child : children) {
                queue.add(child);
                coveredWords.add(child.getCurrentWord());
                if (child.getCurrentWord().equals(endWord)) {
                    targets.add(child);
                }
            }
        }

        return targets.stream().map(target -> target.getHistory()).collect(Collectors.toList());

    }


    public List<Path> nextSetOfChildren(Path currentPath, final List<String> wordList,
                                        final Set<String> coveredWords) {
        return wordList.stream()
                .filter(target -> !coveredWords.contains(target))
                .filter(target -> offByOneLetter(currentPath.getCurrentWord(), target))
                .map(target -> currentPath.extend(target))
                .collect(Collectors.toList());
    }


    public boolean offByOneLetter(String word, String target) {
        if (word.length() != target.length()) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c1 = word.charAt(i);
            char c2 = target.charAt(i);

            if (c1 != c2) {
                count++;
            }

            if (count > 1) {
                return false;
            }
        }

        if (count == 1) {
            return true;
        }

        return false;
    }

    @Test
    public void testOffBy1() {
        assertThat(offByOneLetter("hit", "hat")).isTrue();
        assertThat(offByOneLetter("hit", "haf")).isFalse();
    }

    @Test
    public void testCharArr() {
        char[][] board = {
                {'a'}
        };

        System.out.println(board.length);
        System.out.println(board[0].length);

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                System.out.println("Checking r" + r + ", c: " + c);

            }
        }
    }

    @Test
    public void testFindLadder() {
        assertThat(findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")))
                .isEqualTo(List.of(
                        List.of("hit", "hot", "dot", "dog", "cog"),
                        List.of("hit", "hot", "lot", "log", "cog")));

        assertThat(findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log")))
                .isEmpty();

        assertThat(findLadders("a", "c", List.of("a", "b", "c")))
                .isEqualTo(List.of(List.of("a", "c")));

    }
}