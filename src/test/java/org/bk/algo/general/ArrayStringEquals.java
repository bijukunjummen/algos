package org.bk.algo.general;

import java.util.Arrays;

class ArrayStringEquals {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    
        String w1 = "";
        String w2 = "";
        for (String w: word1) {
            w1 += w;
        }

        for (String w: word2) {
            w2 += w;
        }

        return w1 == w2;
    }
}
