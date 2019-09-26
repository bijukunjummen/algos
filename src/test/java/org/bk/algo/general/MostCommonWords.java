package org.bk.algo.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;

class MostCommonWords {
    public String mostCommonWord(String paragraph, String[] banned) {
        final Set<String> badSet = Arrays.stream(banned).map(word -> word.toLowerCase()).collect(Collectors.toSet());

        final List<String> words = toWords(paragraph);

        final Map<String, Integer> wordsMap = new HashMap<>();
        words.stream()
                .map(word -> word.toLowerCase())
                .filter(word -> notBanned(word, badSet))
                .forEach(word -> {
                    if (wordsMap.containsKey(word)) {
                        int count = wordsMap.get(word);
                        wordsMap.put(word, count + 1);
                    } else {
                        wordsMap.put(word, 1);
                    }
                });

        int mostCommonCount = 0;
        String mostCommon = "";

        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (entry.getValue() > mostCommonCount) {
                mostCommon = entry.getKey();
                mostCommonCount = entry.getValue();
            }
        }
        return mostCommon;
    }

    private boolean notBanned(String word, Set<String> badSet) {
        return !badSet.contains(word);
    }

    private List<String> toWords(String para) {
        String[] words = para.split("[ \".,!?\\[\\]']");
        return Arrays.stream(words).filter(w -> w.length() > 0).collect(Collectors.toList());
    }
}