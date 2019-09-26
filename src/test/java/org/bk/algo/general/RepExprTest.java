package org.bk.algo.general;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RepExprTest {

    @Test
    public void testRep1() {
        Assertions.assertThat(rep("3[abc]4[ab]c")).isEqualTo("abcabcabcababababc");
    }

    @Test
    public void testParsed() {
        Expr expr = new Mult(Arrays.asList(new Rep(3, new Str("abc")), new Rep(4, new Str("ab")), new Str("c")));
        Assertions.assertThat(expr.expand()).isEqualTo("abcabcabcababababc");
    }


    public String rep(String expr) {
        return "";
    }
}

abstract class Expr {
    abstract String expand();
}

class Str extends Expr {
    private final String s;

    public Str(String s) {
        this.s = s;
    }

    public String expand() {
        return s;
    }
}

class Rep extends Expr {
    private final int times;
    private final Expr expr;

    public Rep(int times, Expr expr) {
        this.times = times;
        this.expr = expr;
    }

    public String expand() {
        final StringBuilder res = new StringBuilder();

        for (int i = 0; i < times; i++) {
            res.append(expr.expand());
        }
        return res.toString();
    }
}

class Mult extends Expr {
    private final List<Expr> exprs;

    public Mult(List<Expr> exprs) {
        this.exprs = exprs;
    }

    @Override
    String expand() {
        return exprs.stream()
                .map(expr -> expr.expand())
                .collect(Collectors.joining(""));
    }
}
