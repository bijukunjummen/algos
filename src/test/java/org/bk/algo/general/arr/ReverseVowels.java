package org.bk.algo.general.arr;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseVowels {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l = 0;
        int length = arr.length;
        int r = length - 1;

        while (l < r) {
            while (l < length && !isVowel(arr[l])) {
                l++;
            }

            while (r >= 0 && !isVowel(arr[r])) {
                r--;
            }
            if (l < r) {
                swap(arr, l, r);
                l++;
                r--;
            }
        }
        return new String(arr);
    }

    private void swap(char[] arr, int l, int r) {
        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    private boolean isVowel(char c) {
        return (
                c == 'a' || c == 'A' ||
                        c == 'e' || c == 'E' ||
                        c == 'i' || c == 'I' ||
                        c == 'o' || c == 'O' ||
                        c == 'u' || c == 'U'
        );
    }

    @Test
    void testReverse() {
        assertThat(reverseVowels("hello")).isEqualTo("holle");
    }
}
