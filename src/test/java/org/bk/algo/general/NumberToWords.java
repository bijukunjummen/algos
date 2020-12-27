package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberToWords {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int billion = 1000_000_000;
        int million = 1000_000;
        int thousand = 1000;

        int billionsPlace = num / billion;
        int remBillion = num % billion;
        int millionsPlace = remBillion / million;
        int remMillon = remBillion % million;
        int thousandsPlace = (remMillon) / thousand;
        int onesPlace = remMillon % thousand;
        List<String> stringNum = new ArrayList<>();

        if (billionsPlace != 0) {
            stringNum.addAll(convert(billionsPlace));
            stringNum.add("Billion");
        }

        if (millionsPlace != 0) {
            stringNum.addAll(convert(millionsPlace));
            stringNum.add("Million");
        }

        if (thousandsPlace != 0) {
            stringNum.addAll(convert(thousandsPlace));
            stringNum.add("Thousand");
        }
        stringNum.addAll(convert(onesPlace));
        return String.join(" ", stringNum);
    }

    // from 0 to 999
    private List<String> convert(int h) {
        int hundredPlace = h / 100;
        int remHundreds = h % 100;
        int tensPlace = remHundreds / 10;
        int onesPlace = remHundreds % 10;

        List<String> toWords = new ArrayList<>();
        if (hundredPlace != 0) {
            toWords.add(toWordOnes(hundredPlace));
            toWords.add("Hundred");
        }

        boolean onesCovered = false;
        if (tensPlace != 0) {
            if (tensPlace == 1) {
                int tensAndOnes = tensPlace * 10 + onesPlace;
                onesCovered = true;
                toWords.add(toWordsTeens(tensAndOnes));
            } else {
                toWords.add(toWordsTens(tensPlace));
            }
        }

        if (!onesCovered && onesPlace != 0) {
            toWords.add(toWordOnes(onesPlace));
        }
        return toWords;
    }

    private String toWordsTens(int tensPlace) {
        switch (tensPlace) {
            case 1:
                return "Ten";
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
            default:
                return "";
        }
    }

    // from 10 to 19
    private String toWordsTeens(int num) {
        switch (num) {
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
            default:
                return "";
        }
    }

    private String toWordOnes(int num) {
        switch (num) {
            case 0:
                return "Zero";
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            default:
                return "";
        }
    }

    @Test
    void testNumberToWords() {
//        System.out.println(Integer.MAX_VALUE);
        assertThat(numberToWords(2_146_345_245))
                .isEqualTo("Two Billion One Hundred Forty Six Million Three Hundred Forty Five Thousand Two Hundred Forty Five");

        assertThat(numberToWords(0)).isEqualTo("Zero");
    }
}