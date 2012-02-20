package org.bk.algo001.gcd;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class GcdTest {
	
	@Test
	public void testGcdOf4And6Is2(){
		assertThat(Gcd.of(4, 6), is(2));
	}

	@Test
	public void testGcdOf4And4Is4(){
		assertThat(Gcd.of(4, 4), is(4));
	}

	@Test
	public void testGcdOf17And23Is1(){
		assertThat(Gcd.of(17, 23), is(1));
	}

	@Test
	public void testGcdOf27And18Is9(){
		assertThat(Gcd.of(27, 18), is(9));
	}
}
