package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        double result = numerator * 1.0d / denominator;
        int intResult = numerator / denominator;
        if (result == intResult * (1.0)) {
            return "" + intResult;
        } else {
            return replaceRepeating("" + result);
        }
    }

    private String replaceRepeating(String n) {
        int startOfDecimal = n.indexOf(".");

        String num = n.substring(0, startOfDecimal);
        String remaining = n.substring(startOfDecimal + 1);
        String repeating = findRepeating(remaining);
        if (repeating != null) {
            return num + "." + "(" + repeating + ")";
        } else {
            return num + "." + remaining;
        }
    }


    private String findRepeating(String s) {
        int len = s.length();
        for (int l = 1; l <= len; l++) {
            String possiblePattern = s.substring(0, l);
            Pattern toMatch = Pattern.compile("(" + possiblePattern + "){2,}");
            Matcher matcher = toMatch.matcher(s);
            if (matcher.matches()) {
                return possiblePattern;
            }
        }
        return null;
    }

    @Test
    void testFractionToDecimal() {
        System.out.println(fractionToDecimal(4, 333));
        System.out.println(fractionToDecimal(1, 2));
    }


}