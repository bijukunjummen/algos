package org.bk.algo.general;

import java.util.ArrayList;
import java.util.List;

class GFG {
    static final String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GUQ", "EE"};
    static final int n = dictionary.length;
    static final int M = 3, N = 3;

    static boolean isWord(String str) {
        for (int i = 0; i < n; i++)
            if (str.equals(dictionary[i]))
                return true;
        return false;
    }

    static List<String> findWordsUtil(final int r, final int c, final boolean[][] visited, final char[][] boggle,
                                      final String prefix, final List<String> words) {
        String s = prefix + boggle[r][c];

        visited[r][c] = true;

        if (isWord(s)) {
            words.add(s);
        }
        for (int i = r - 1; i <= r + 1 && i < M; i++) {
            for (int j = c - 1; j <= c + 1 && j < N; j++) {
                if (i >= 0 && j >= 0 && !visited[i][j]) {
                    findWordsUtil(i, j, visited, boggle, s, words);
                }
            }
        }
        visited[r][c] = false;
        return words;
    }

    static List<String> findWords(char boggle[][]) {
        boolean visited[][] = new boolean[M][N];

        // Initialize current string
        String str = "";

        List<String> words = new ArrayList<>();

        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                findWordsUtil(i, j, visited, boggle, str, words);

        return words;
    }

    public static void main(String args[]) {
        char[][] boggle = {
                {'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}
        };

        System.out.println("Following words of dictionary are present");
        System.out.println(findWords(boggle));
    }
} 