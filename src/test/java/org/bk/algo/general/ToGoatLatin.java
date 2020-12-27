package org.bk.algo.general;

import org.junit.jupiter.api.Test;

class ToGoatLatin {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        
        StringBuilder gl = new StringBuilder();
        boolean isFirst = true;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (startsWithVowel(word)) {
                gl.append((isFirst?"":" ") + word + "ma" + multiply(i + 1, "a"));
            } else {
                gl.append((isFirst?"":" ") + word.substring(1) + word.charAt(0) + "ma" + multiply(i + 1, "a"));
            }
            if (isFirst){
                isFirst = false;
            }
        }
        return gl.toString();
    }
    
    private boolean startsWithVowel(String word) {
        Character lc = Character.toLowerCase(word.charAt(0));
        return lc == 'a' || lc == 'e' || lc == 'i' || lc == 'o' || lc == 'u';
    }
    
    private String multiply(int times, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    @Test
    void testGL() {
        System.out.println(toGoatLatin("I speak Goat Latin"));
    }
}