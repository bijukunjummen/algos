package org.bk.algo.kata;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class MethodReferenceTests {

    @Test
    public void functionUsingAMethodReference() {
        Function<Integer, String> fn1 = i -> i.toString();

        assertThat(fn1.apply(10)).isEqualTo("10");

        Function<Integer, String> fn2 = Object::toString;

        assertThat(fn2.apply(10)).isEqualTo("10");
    }

    @Test
    public void staticMethodAsAMethodReference() {
        //Explicit types
        BiFunction<String, String, String> fn1 =
                (String param1, String param2) -> TestClassWithStaticMethod.twoParamMethod(param1, param2);


        //Types implied..
        BiFunction<String, String, String> fn2 =
                (param1, param2) -> TestClassWithStaticMethod.twoParamMethod(param1, param2);

        //With Method reference
        BiFunction<String, String, String> fn3 =
                TestClassWithStaticMethod::twoParamMethod;

        assertThat(fn3.apply("hello", "world")).isEqualTo("helloworld");
    }

    @Test
    public void constructorAsMethodReference() {
        Function<String, String> fn1 = (String p1) -> new String(p1);

        Function<String, String> fn2 = String::new;

        assertThat(fn2.apply("hello")).isEqualTo("hello");
    }
}

class TestClassWithStaticMethod {
    static String twoParamMethod(String param1, String param2) {
        return param1 + param2;
    }
}
