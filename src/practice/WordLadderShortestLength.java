package practice;

import java.util.*;

public class WordLadderShortestLength {
    public static void main(String[] args) {

        WordLadderShortestLength ob = new WordLadderShortestLength();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

//        String beginWord = "hot";
//        String endWord = "dog";
//        List<String> wordList = Arrays.asList("hot", "dog");

        int transformation = ob.ladderLength(beginWord, endWord, wordList);
        System.out.println(transformation);
    }

    // Using BFS approach
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;

        Map<String, List<String>> genericWordRealWord = genericWordToRealWord(beginWord, endWord, wordList);
        Map<String, Integer> distance = new HashMap<>();

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        distance.put(beginWord, 1);

        while (!q.isEmpty()) {
            String currentWord = q.poll();

            if (currentWord.equals(endWord)) {
                return distance.get(currentWord);
            }

            for (int i = 0; i < currentWord.length(); i++) {
                String genericWord = currentWord.substring(0, i) + "*" + currentWord.substring(i + 1);

                List<String> realWords = genericWordRealWord.get(genericWord);

                for (String realWord : realWords) {

                    if (distance.get(realWord) == null) {
                        distance.put(realWord, distance.get(currentWord) + 1);
                        q.offer(realWord);
                    }
                }
            }
        }
        return 0;
    }

    private Map<String, List<String>> genericWordToRealWord(String beginWord, String
            endWord, List<String> wordList) {
        Map<String, List<String>> genericWordToRealWord = new HashMap<>();

        for (String word1 : wordList) {

            for (int i = 0; i < word1.length(); i++) {
                String newWord = word1.substring(0, i) + "*" + word1.substring(i + 1);
                List<String> list = genericWordToRealWord.computeIfAbsent(newWord, s -> new ArrayList<>());

                if(!list.contains(word1)){
                    list.add(word1);
                }
                genericWordToRealWord.put(newWord, list);
            }

        }

        for (int i = 0; i < beginWord.length(); i++) {
            String newWord = beginWord.substring(0, i) + "*" + beginWord.substring(i + 1);
            List<String> list = genericWordToRealWord.computeIfAbsent(newWord, s -> new ArrayList<>());
            if(!list.contains(beginWord)){
                list.add(beginWord);
            }
            genericWordToRealWord.put(newWord, list);
        }

        return genericWordToRealWord;
    }
}
