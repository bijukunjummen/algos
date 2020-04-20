package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class FindFunctionArgs {

    List<Tuple<Integer, Integer>> findFuncArgs(BiFunction<Integer, Integer, Integer> fn, int result) {
        List<Tuple<Integer, Integer>> res = new ArrayList<>();
        for (int x = 0; x <= result; x++) {
            int y = searchForY(fn, x, 0, result, result);
            if (y != -1) {
                res.add(new Tuple<>(x, y));
            }
        }
        return res;
    }

    private int searchForY(BiFunction<Integer, Integer, Integer> fn, int x, int lo, int hi, int result) {
        if (hi <= lo) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        int res = fn.apply(x, mid);

        if (res == result) {
            return mid;
        } else if (res < result) {
            return searchForY(fn, x, mid + 1, hi, result);
        } else {
            return searchForY(fn, x, lo, mid - 1, result);
        }
    }

    @Test
    void testFuncArgs() {
        BiFunction<Integer, Integer, Integer> fn = (x, y) -> x * x + y;

        List<Tuple<Integer, Integer>> res = findFuncArgs(fn, 50);

        System.out.println(res.toString());
    }

}

class Tuple<T1, T2> {
    T1 t1;
    T2 t2;

    Tuple(T1 t1, T2 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "t1=" + t1 +
                ", t2=" + t2 +
                '}';
    }
}
