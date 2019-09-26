package org.bk.algo.general.fibonacci;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class FibonacciUtilsTest {

    @Test
    public void testGetRecFibAtN() {
        assertThat(FibonacciUtils.getRecFibAt(0), equalTo(0l));
        assertThat(FibonacciUtils.getRecFibAt(1), equalTo(1l));
        assertThat(FibonacciUtils.getRecFibAt(2), equalTo(1l));
        assertThat(FibonacciUtils.getRecFibAt(3), equalTo(2l));
        assertThat(FibonacciUtils.getRecFibAt(4), equalTo(3l));
        assertThat(FibonacciUtils.getRecFibAt(20), equalTo(6765l));
    }

    @Test
    public void testGetIterFibAtN() {
        assertThat(FibonacciUtils.getIterFibAt(0), equalTo(0l));
        assertThat(FibonacciUtils.getIterFibAt(1), equalTo(1l));
        assertThat(FibonacciUtils.getIterFibAt(2), equalTo(1l));
        assertThat(FibonacciUtils.getIterFibAt(3), equalTo(2l));
        assertThat(FibonacciUtils.getIterFibAt(4), equalTo(3l));
        assertThat(FibonacciUtils.getIterFibAt(20), equalTo(6765l));
    }

}
