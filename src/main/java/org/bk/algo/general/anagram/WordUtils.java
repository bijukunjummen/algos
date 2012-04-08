package org.bk.algo.general.anagram;

import java.util.HashSet;
import java.util.Set;

public class WordUtils {
	public static Set<String> allAnagrams(String word){
		Set<String> aSet = new HashSet<String>();
		allAnagrams("", word, aSet);
		return aSet;
	}
	
	private static void allAnagrams(String prefix, String word, Set<String> aList){
		if (word.length()==0) {
			aList.add(prefix)  ;
			return;
		}
		
		for (int i=0;i<word.length();i++){
			allAnagrams(prefix + word.charAt(i), word.substring(0,i)+word.substring(i+1, word.length()), aList);
		}
	}

}
