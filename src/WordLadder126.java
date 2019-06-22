import java.util.*;
import java.util.stream.Collectors;

public class WordLadder126 {
    public static void main(String[] args) {

//        String beginWord = "hit";
//        String endWord = "cog";
//        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        String beginWord = "a";
        String endWord = "c";
        List<String> wordList = Arrays.asList("a", "b", "c");

        WordLadder126 ob = new WordLadder126();
        List<List<String>> ladders = ob.findLadders(beginWord, endWord, wordList);
        System.out.println(ladders);
    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> l = new LinkedList<>();

        if (beginWord == null || beginWord.isEmpty() || endWord == null || endWord.isEmpty()
                || wordList.isEmpty() || !wordList.contains(endWord)) {
            return l;
        }


        Map<String, List<String>> m = preprocessWordList(wordList);

        return bfs(m, beginWord, endWord);

    }

    private List<List<String>> bfs(Map<String, List<String>> m, String beginWord, String endWord) {

        List<List<String>> result = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;

        Queue<Entry> q = new LinkedList<>();
        Set<String> isVisited = new HashSet<>();

        q.add(new Entry(beginWord));
        isVisited.add(beginWord);

        while (!q.isEmpty()) {
            Entry e = q.remove();
            List<String> words = e.getWords();

            if (words.get(words.size() - 1).equals(endWord)) {
                result.add(words);
                if (minLength > words.size()) {
                    minLength = words.size();
                }
                continue;
            }

            String word = words.get(words.size() - 1);

            for (int i = 0; i < word.length(); i++) {
                String genericWord = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> relatedWords = m.get(genericWord);

                if (relatedWords != null && !relatedWords.isEmpty()) {
                    for (String rw : relatedWords) {
                        if (!isVisited.contains(rw) && !rw.equals(word)) {

                            Entry entry = new Entry(e.getWords());
                            entry.addElement(rw);
                            q.add(entry);

                            if (!rw.equals(endWord)) {
                                isVisited.add(rw);
                            }
                        }
                    }
                }

            }
        }

        final int val = minLength;

        if (!result.isEmpty()) {
            result = result.stream().filter(s -> s.size() == val)
                    .collect(Collectors.toList());
        }
        return result;
    }

    private Map<String, List<String>> preprocessWordList(List<String> wordList) {

        Map<String, List<String>> m = new HashMap<>();

        for (String word : wordList) {

            for (int i = 0; i < word.length(); i++) {
                String genericWord = word.substring(0, i) + "*" + word.substring(i + 1);

                List<String> previous = m.get(genericWord);

                if (previous == null) {
                    previous = new ArrayList<>();
                    previous.add(word);
                    m.put(genericWord, previous);
                } else {
                    if (!previous.contains(word)) {
                        previous.add(word);
                        m.put(genericWord, previous);
                    }
                }
            }
        }
        return m;
    }

    static class Entry {
        private List<String> words;
//        private int level;

        public Entry() {
            words = new LinkedList<>();
        }

        public Entry(String e) {
            words = new LinkedList<>();
            words.add(e);
        }

        public Entry(List<String> w) {
            this.words = new LinkedList<>();
            this.words.addAll(w);
        }

        private void addElement(String e) {
            words.add(e);
        }

        public List<String> getWords() {
            return words;
        }
    }
}


