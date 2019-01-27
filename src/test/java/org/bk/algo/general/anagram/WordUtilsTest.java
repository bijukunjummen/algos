package org.bk.algo.general.anagram;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class WordUtilsTest {

	@Test
	public void testSmallAnagrams() {
		String word = "tes";
		Set<String> anagrams = WordUtils.allAnagrams(word);
		System.out.println(anagrams);
		assertThat(anagrams, hasItems("tes", "tse", "est", "ets", "set", "ste"));
	}

	@Test
	public void testAnagramsWith5Uniques() {
		String word = "abcdefgh";
		Set<String> anagrams = WordUtils.allAnagrams(word);
		
		assertThat(anagrams.size(),  is(8 * 7 * 6 * 5 * 4 * 3 * 2));
	}
	
	@Test
	public void isPermutation() {
		assertThat(WordUtils.isPermutation("abc", "bca"), is(true));
		assertThat(WordUtils.isPermutation("abdc", "bca"), is(false));
	}

}
