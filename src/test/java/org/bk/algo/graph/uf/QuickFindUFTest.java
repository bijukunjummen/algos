package org.bk.algo.graph.uf;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class QuickFindUFTest {

	@Test
	public void testUnionFind() {
		QuickFindUF uf = new QuickFindUF(10);
		
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
	
	@Test
	public void testUnionFind2() {
		QuickFindUF uf = new QuickFindUF(10);
		
		uf.union(5,6);
		uf.union(4,6);
		uf.union(5,1);
		uf.union(7,5);
		uf.union(9,4);
		uf.union(3,0);
		
		assertThat(uf.connected(5,6), is(true));
		
	}

}