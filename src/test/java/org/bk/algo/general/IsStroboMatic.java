package org.bk.algo.general;

class IsStroboMatic {
    public boolean isStrobogrammatic(String num) {
        int b = 0;
        int e = num.length() - 1;
        
        while (b <= e) {
            char cB = num.charAt(b);
            char cE = num.charAt(e);
            
            if (!(isStrobo(cB) && isStrobo(cE))) return false;
            
            if (!(strobo(cB) == cE)) return false;
            b++;
            e--;
        }
        
        return true;
    }
    
    boolean isStrobo(char c) {
        return c == '0' || c == '1' || c == '6' || c == '8' || c == '9';
    }
    
    char strobo(char c) {
        switch(c) {
            case '0': return '0';
            case '1': return '1';
            case '6': return '9';
            case '8': return '8';
            case '9': return '6';
            default: throw new IllegalStateException("Unexpected char: " + c);
        }
    }
}