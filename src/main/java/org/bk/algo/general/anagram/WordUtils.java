package org.bk.algo.general.anagram;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordUtils {
	public static Set<String> allAnagrams(String word){
		return allAnagrams("", word);
	}
	
	private static Set<String> allAnagrams(String prefix, String word){
		if (word.length()==0) {
			return Collections.singleton(prefix)  ;
		}
		Set<String> aSet = new HashSet<String>();
		for (int i=0;i<word.length();i++){
			aSet.addAll(allAnagrams(prefix + word.charAt(i), word.substring(0,i)+word.substring(i+1, word.length())));
		}
		return aSet;
	}

}
