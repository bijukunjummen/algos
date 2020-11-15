package org.bk.algo.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TelephoneNumberToTextCombo {
    public List<String> letterCombinations(String digits) {
        char[] chs = digits.toCharArray();
        if (chs.length == 0) return List.of();
        List<String> result = new ArrayList<>();
        letterCombinations(chs, 0, "", result);
        return result;
    }

    private void letterCombinations(char[] chs, int idx, String prefix, List<String> result) {
        if (idx > chs.length - 1) {
            result.add(prefix);
            return;
        }

        for (char c: getDigitsForNum(chs[idx])) {
            letterCombinations(chs, idx + 1, prefix + c, result);
        }

    }

    private List<Character> getDigitsForNum(char n) {
        switch(n) {
            case '2': return List.of('a', 'b','c');
            case '3': return List.of('d', 'e','f');
            case '4': return List.of('g', 'h','i');
            case '5': return List.of('j', 'k','l');
            case '6': return List.of('m', 'n','o');
            case '7': return List.of('p', 'q','r', 's');
            case '8': return List.of('t', 'u','v');
            case '9': return List.of('w', 'x','y', 'z');
            default: return List.of();
        }
    }
}