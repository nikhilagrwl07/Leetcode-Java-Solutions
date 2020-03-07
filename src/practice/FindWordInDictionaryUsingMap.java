package practice;

import java.util.HashMap;
import java.util.Map;

public class FindWordInDictionaryUsingMap {
    public static void main(String[] args) {
        String dictionary[] = {"find", "a", "geeks","all", "for", "on", "geeks", "answers", "inter"};
        String sentence[] = {"find", "all", "answers", "on", "geeks", "for", "geeks"};

        FindWordInDictionaryUsingMap ob = new FindWordInDictionaryUsingMap();
        boolean result = ob.searchGivenWordInDictionary(dictionary, sentence);
        System.out.println(result);
    }

    // Time Complexity - O(number of words in dictionary) assuming inserting one word in map takes O(1) time
    public boolean searchGivenWordInDictionary(String[] dict, String[] sentence) {

        // build map with dictionary
        Map<String, Integer> wordToOccurenceMap = new HashMap<>();

        for (String word : dict) {
            wordToOccurenceMap.merge(word, 1, Integer::sum);
        }

        for (String word : sentence) {
            Integer freq = wordToOccurenceMap.get(word);
            if (freq == null) {
                return false;
            }
            if (freq - 1 == 0) {
                wordToOccurenceMap.remove(word);
            }
            else{
                wordToOccurenceMap.put(word, freq-1);
            }

        }

        return true;
    }
}
