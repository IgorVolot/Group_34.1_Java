package ait.map.word;


import java.util.*;

public class Anagram {
    public static boolean isAnagram(String word, String part) {
        if (part == null || part.isEmpty() || part.length() > word.length()) {
            return false;
        }
        word = word.toLowerCase();
        part = part.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (char letter : word.toCharArray()) {
            map.merge(letter, 1, (a, b) -> a + b);
        }
        for (char letter : part.toCharArray()) {
            int count = map.getOrDefault(letter, 0);
            if (count == 0) {
                return false;
            }
            map.put(letter, count - 1);
        }
        return true;
    }
}
