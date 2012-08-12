package org.bk.algo.graph.uf;


import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class WeightedQuickUnionWithPathCompressionUFTest {

	@Test
	public void testUnionFind() {
		WeightedQuickUnionWithPathCompressionUF uf = new WeightedQuickUnionWithPathCompressionUF(10);
		
		uf.union(1,2);
		uf.union(3,4);
		uf.union(5,6);
		uf.union(7,8);
		uf.union(0,5);
		uf.union(7,9);
		uf.union(1,9);
		
		assertThat(uf.connected(0,6), is(true));
		assertThat(uf.connected(1,9), is(true));
		assertThat(uf.connected(0,1), is(false));
		
	}

}
