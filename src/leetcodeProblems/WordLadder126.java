package leetcodeProblems;

import java.util.*;

public class WordLadder126 {
    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

//        String beginWord = "a";
//        String endWord = "c";
//        List<String> wordList = Arrays.asList("a", "b", "c");

        WordLadder126 ob = new WordLadder126();
        List<List<String>> ladders = ob.findLadders(beginWord, endWord, wordList);
        System.out.println(ladders);
    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {


        Map<String, Integer> distance = new HashMap<>();
        Map<String, List<String>> transformation = new HashMap<>();

        //BFS
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        distance.put(beginWord, 1);
        Map<String, List<String>> genericWordToRealWords = preProcessWordList(wordList);
        Set<String> isVisited = new HashSet<>();


        while (!q.isEmpty()) {

            String word = q.remove();
            if (word.equals(endWord)) {
                continue;
            }

            for (int index = 0; index < word.length(); index++) {

                String genericWord = word.substring(0, index) + "*" + word.substring(index + 1);
                List<String> realWords = genericWordToRealWords.getOrDefault(genericWord, new ArrayList<>());

                for (String s : realWords) {
                    if (!isVisited.contains(s)) {
                        q.add(s);
                        distance.put(s, distance.get(word) + 1);

                        List<String> orDefault = transformation.getOrDefault(word, new ArrayList<>());
                        if (!orDefault.contains(s) && !s.equals(word)) {
                            orDefault.add(s);
                            transformation.put(word, orDefault);
                        }

                    }
                }

            }
            isVisited.add(word);
        }


        isVisited.clear();
        collectAllPath(beginWord, endWord, transformation, 0, new ArrayList<>(), isVisited);
        return collectShortestPath(ans);

    }

    List<List<String>> ans = new ArrayList<>();

    private List<List<String>> collectShortestPath(List<List<String>> ans) {

        int minLength = Integer.MAX_VALUE;

        for (List<String> l : ans) {
            minLength = Math.min(minLength, l.size());
        }
        List<List<String>> finalAns = new ArrayList<>();

        for (List<String> l : ans) {
            if (l.size() == minLength) {
                finalAns.add(l);
            }
        }
        return finalAns;
    }


    private void collectAllPath(String beginWord, String endWord, Map<String, List<String>> transformation,
                                int index, List<String> result, Set<String> isVisited) {

        if (isVisited.contains(beginWord))
            return;

        result.add(index, beginWord);

        if (beginWord.equals(endWord)) {
            List<String> cloned_list = new ArrayList<>(result.subList(0, index + 1));
            ans.add(cloned_list);
            return;
        }

        if (transformation.get(beginWord) != null) {
            List<String> nextWord = transformation.get(beginWord);

            for (String w : nextWord) {
                collectAllPath(w, endWord, transformation, index + 1, result, isVisited);
            }
        }
        isVisited.add(beginWord);

    }


    private Map<String, List<String>> preProcessWordList(List<String> wordList) {

        Map<String, List<String>> genericWordToRealWord = new HashMap<>();
        // genericWord to real word mapping

        for (String word : wordList) {

            for (int index = 0; index <= word.length() - 1; index++) {
                String genericWord = word.substring(0, index) + "*" + word.substring(index + 1);
                List<String> orDefault = genericWordToRealWord.getOrDefault(genericWord, new ArrayList<>());
                if (!orDefault.contains(word)) {
                    orDefault.add(word);
                }
                genericWordToRealWord.put(genericWord, orDefault);
            }
        }

        return genericWordToRealWord;
    }

}


