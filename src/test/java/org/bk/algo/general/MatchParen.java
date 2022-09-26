package org.bk.algo.general;

import java.util.Stack;

class MatchParen {
    public boolean isValid(String s) {
        Stack<Character> ops = new Stack<>();
        for (char c:  s.toCharArray()) {
            if (isOpenParen(c)) {
                ops.push(c);
            }else if (isCloseParen(c)) {
                if (ops.isEmpty()) return false;
                Character fromStack = ops.pop();
                if (fromStack != null) {
                    if (!isCorrespondingClosingFor(fromStack, c)) {
                        return false;
                    }
                }
            }
        }

        if (!ops.isEmpty()) {
            return false;
        }

        return true;
    }

    public boolean isOpenParen(Character c) {
        for (Character e: "({[".toCharArray()) {
            if (c.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCloseParen(Character c) {
        for (Character e: ")}]".toCharArray()) {
            if (c.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCorrespondingClosingFor(Character c, Character m) {
        if (c.equals('(')) {
            return m.equals(')');
        }
        if (c.equals('{')) {
            return m.equals('}');
        }
        if (c.equals('[')) {
            return m.equals(']');
        }

        return false;
    }
}
