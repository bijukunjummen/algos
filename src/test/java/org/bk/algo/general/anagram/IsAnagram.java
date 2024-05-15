package org.bk.algo.general.anagram;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class IsAnagram {
  public boolean isAnagram(String s, String t) {
    Map<Character, Integer> count1 = createCharMap(s);
    Map<Character, Integer> count2 = createCharMap(t);
    System.out.println(count1);
    System.out.println(count2);
    return (count1.equals(count2));
  }

  private Map<Character, Integer> createCharMap(String s)  {
    char[] arr = s.toCharArray();
    Map<Character, Integer> charMap = new HashMap<>();
    for (char c: arr) {
      int count = charMap.getOrDefault(c, 0);
      charMap.put(c, count + 1);
    }
    return charMap;
  }

  @Test
  void testAnagram() {
    assertThat(isAnagram("rat", "cat")).isFalse();
  }

}
