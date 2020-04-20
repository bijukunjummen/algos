package org.bk.algo.general;

public class LongestPalindrome2 {

    public String longestPalindrome(String s) {
        for (int win = s.length(); win >= 1; win--) {
            String pal = firstPalindromeIn(s, win);
            if (pal != null) {
                return pal;
            }
        }
        return "";
    }

    public String firstPalindromeIn(String s, int win) {
        int lastIndex = s.length() - win;

        for (int i = 0; i <= lastIndex; i++) {
            String sub = s.substring(i, i + win);
            if (isPalindrome(sub)) {
                return sub;
            }
        }

        return null;
    }


    //0, 1, 2, 3
    private boolean isPalindrome(String s) {
        int lastIndex = s.length() - 1;
        int mid = lastIndex / 2;

        for (int i = 0; i <= mid; i++) {
            if (!(s.charAt(i) == s.charAt(lastIndex - i))) {
                return false;
            }
        }

        return true;
    }

}
