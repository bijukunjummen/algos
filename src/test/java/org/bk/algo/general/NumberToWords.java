package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

class NumberToWords {
    public String numberToWords(int num) {
        String s = String.valueOf(num);
        if (s.length() > 9) {

        }
        return "";
    }

    List<String> convert(String d3) {
        List<String> result = new ArrayList<>();
        char charAtHundreds = d3.charAt(0);
        String hundreds = onesPlace(charAtHundreds - '0');
        if (hundreds.length() > 0) {
            result.add(hundreds);
            result.add("hundred");
        }
        char charAtTens = d3.charAt(1);
        if (charAtTens - '0' == 1) {
            char charAtOnes = d3.charAt(2);
            String tensWithOne = tensPlaceWithOne((charAtTens - '0') * 10 + (charAtOnes - '0'));
            result.add(tensWithOne);
            return result;
        }
        String atTens = tensPlace(charAtTens - '0');

        if (atTens.length() > 0) {
            result.add(atTens);
        }

        char charAtOnes = d3.charAt(2);
        String atOnes = onesPlace(charAtOnes - '0');

        if (atOnes.length() > 0) {
            result.add(atOnes);
        }
        return result;
    }

    private String onesPlace(int n) {
        switch (n) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            case 0:
                return "";
            default:
                throw new IllegalStateException("ones place asked for :" + n);
        }
    }

    private String tensPlaceWithOne(int n) {
        switch (n) {
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
            case 15:
                return "fifteen";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eighteen";
            case 19:
                return "nineteen";
            default:
                throw new IllegalStateException("tensPlaceWithOne place asked for :" + n);
        }
    }

    private String tensPlace(int n) {
        switch (n) {
            case 1:
                return "ten";
            case 2:
                return "twenty";
            case 3:
                return "thirty";
            case 4:
                return "forty";
            case 5:
                return "fifty";
            case 6:
                return "sixty";
            case 7:
                return "seventy";
            case 8:
                return "eighty";
            case 9:
                return "ninety";
            case 0:
                return "";
            default:
                throw new IllegalStateException("ones place asked for :" + n);
        }
    }

    @Test
    void testConvertD3() {
        assertThat(convert("135")).isEqualTo(List.of("one", "hundred", "thirty", "five"));
        assertThat(convert("105")).isEqualTo(List.of("one", "hundred", "five"));
        assertThat(convert("035")).isEqualTo(List.of("thirty", "five"));
        assertThat(convert("005")).isEqualTo(List.of("five"));
        assertThat(convert("985")).isEqualTo(List.of("nine", "hundred", "eighty", "five"));
        assertThat(convert("502")).isEqualTo(List.of("five", "hundred", "two"));
    }

}