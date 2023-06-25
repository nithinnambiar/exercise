package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> anagramMap = new HashMap<>();
        for(String word: strs) {

            String sortedWord = this.sort(word);
            List<String> anagrams =null;
            if(anagramMap.containsKey(sortedWord)) {
                anagrams = anagramMap.get(sortedWord);
                anagrams.add(word);

            }
            else {
                anagrams = new ArrayList<>();
                anagrams.add(word);
                anagramMap.put(sortedWord, anagrams);
            }

        }
        return anagramMap.values().stream().toList();
    }

    private String sort(String word) {
        char[] wordArray = word.toLowerCase().toCharArray();
        Arrays.sort(wordArray);
        return String.valueOf(wordArray);

    }
}
