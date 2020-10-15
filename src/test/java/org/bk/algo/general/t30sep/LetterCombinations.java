package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        List<String> result =  nextCombination(0, len, digits, List.of(""));
        if (result.equals(List.of(""))) {
            return List.of();
        }
        return result;
    }

    private List<String> nextCombination(int idx, int len, String digits, List<String> currPrefixes) {
        if (idx == len) {
            return currPrefixes;
        }

        int digit = digits.charAt(idx) - '0';
        List<String> newPrefixes =
                currPrefixes.stream()
                        .flatMap(prefix ->
                                digitToCharMapping(digit)
                                        .stream()
                                        .map(c -> prefix + c))
                        .collect(Collectors.toList());

        return nextCombination(idx + 1, len, digits, newPrefixes);
    }

    private List<String> digitToCharMapping(int digit) {
        switch(digit) {
            case 2: return List.of("a", "b", "c");
            case 3: return List.of("d", "e", "f");
            case 4: return List.of("g", "h", "i");
            case 5: return List.of("j", "k", "l");
            case 6: return List.of("m", "n", "o");
            case 7: return List.of("p", "q", "r", "s");
            case 8: return List.of("t", "u", "v");
            case 9: return List.of("w", "x", "y", "z");
            default: return List.of();
        }
    }

    @Test
    void testBasic() {
        System.out.println(letterCombinations("23"));
    }
}