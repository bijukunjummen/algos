package org.bk.algo.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TelephoneNumberToTextCombo {
    public List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        if (chars.length == 0) {
            return Arrays.asList();
        }
        
        return letterCombs(chars, "");
    }
    
    List<String> letterCombs(char[] chars, String prefix) {
        //System.out.println("current prefix = " + prefix);
        //System.out.println("current array = " + Arrays.toString(chars));
        if (chars.length == 0) {
            return Arrays.asList(prefix);
        }
        
        char firstChar = chars[0];
        List<String> list = new ArrayList<>();
        for (char ch: forDigit(Character.getNumericValue(firstChar))) {
            list.addAll(letterCombs(Arrays.copyOfRange(chars, 1, chars.length), prefix + ch));
        }
        
        return list;        
    }
    
    public char[] forDigit(int digit) {
        
        if (digit == 2) {
            return new char[]{'a', 'b', 'c'};
        } else if (digit == 3) {
            return new char[]{'d', 'e', 'f'};
        } else if (digit == 4) {
            return new char[]{'g', 'h', 'i'};
        } else if (digit == 5) {
            return new char[]{'j', 'k', 'l'};
        } else if (digit == 6) {
            return new char[]{'m', 'n', 'o'};
        } else if (digit == 7) {
            return new char[]{'p', 'q', 'r', 's'};
        } else if (digit == 8) {
            return new char[]{'t', 'u', 'v'};
        } else if (digit == 9) {
            return new char[]{'w', 'x', 'y', 'z'};
        }
        return new char[]{};
    }
}